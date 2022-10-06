import base64
import hashlib
import json
import uuid
from typing import Optional
from urllib.request import urlopen

import boto3
import pydantic
from authlib.jose import JWTClaims, JsonWebToken
from aws_lambda_powertools.event_handler import APIGatewayHttpResolver, Response, content_types
from aws_lambda_powertools.event_handler.exceptions import BadRequestError, NotFoundError, UnauthorizedError
from aws_lambda_powertools.utilities.typing import LambdaContext

from utils.models import CreatePresetsRequest, Settings, CreateSetupsRequest, CreateSetupRequest

session = boto3.Session(region_name="us-west-2")
dynamodb = session.resource("dynamodb")
table = dynamodb.Table("relight-legacy-sharedata")
s3 = session.resource("s3")
bucket = s3.Bucket("relight-legacy-sharedata")
img_bucket = s3.Bucket("relight-share-images")

IMG_BASE_URL = "https://i.relight.qwewqa.xyz"
SHARE_BASE_URL = "https://share.relight.qwewqa.xyz"
SIM_BASE_URL = "https://relight.qwewqa.xyz/legacy/7af4ebdea0e3233992ff85dc0fba28f45c7da32a/index.html"

settings = Settings()
app = APIGatewayHttpResolver()

MAX_SYNC_DATA_SIZE = 20_000_000
MAX_PRESET_SHARE_DATA_SIZE = 100_000
MAX_SETUP_SHARE_DATA_SIZE = 100_000


def generate_id() -> str:
    return uuid.uuid4().hex


def get_auth_token_from_header() -> Optional[str]:
    header = app.current_event.get_header_value("Authorization")
    if header is None or " " not in header:
        return None
    token_type, token = header.split(" ", 1)
    if token_type != "Bearer":
        return None
    return token


def get_claims() -> JWTClaims:
    token = get_auth_token_from_header()
    if token is None:
        raise UnauthorizedError("No token provided")
    jsonurl = urlopen(settings.jwks_url)
    jwks = json.loads(jsonurl.read())

    def get_key(header, _payload):
        for key in jwks["keys"]:
            if key["kid"] == header["kid"]:
                return {
                    "kty": key["kty"],
                    "kid": key["kid"],
                    "use": key["use"],
                    "n": key["n"],
                    "e": key["e"]
                }
        raise RuntimeError("Unable to find appropriate key")

    try:
        jwt = JsonWebToken(["RS256"])
        payload = jwt.decode(
            token,
            get_key,
            claims_params={
                "iss": settings.token_issuer_url,
                "aud": settings.audience,
            }
        )
        payload.validate_iss()
        payload.validate()
    except Exception:
        raise UnauthorizedError("Authentication failed")
    return payload


def get_user_id() -> str:
    return get_claims().sub


@app.get("/share/presets/get/<preset_id>")
def get_presets(preset_id: str):
    if len(preset_id) != 32:
        raise BadRequestError("Invalid preset ID")
    ddb_key = f"presets#{preset_id}"
    response = table.get_item(Key={"id": ddb_key})
    if "Item" not in response:
        raise NotFoundError
    item = response["Item"]
    s3_key = item["s3_key"]
    data = json.loads(bucket.Object(s3_key).get()["Body"].read())
    return {"presets": data}


@app.post("/share/presets/create")
def create_presets():
    try:
        json_data = app.current_event.json_body
        data = CreatePresetsRequest(**json_data)
    except pydantic.ValidationError as e:
        print(e)
        raise BadRequestError(f"Invalid preset data.")
    preset_id = generate_id()
    s3_key = f"presets/{preset_id}"
    ddb_key = f"presets#{preset_id}"
    body = json.dumps(json_data["presets"]).encode("utf-8")
    if len(body) > MAX_PRESET_SHARE_DATA_SIZE:
        raise BadRequestError(f"Preset data is too large.")
    bucket.Object(s3_key).put(Body=body)
    table.put_item(
        Item={
            "id": ddb_key,
            "presets_name": data.name,
            "s3_key": s3_key,
        }
    )
    return {"id": preset_id}


@app.get("/share/setups/get/<setup_id>")
def get_setups(setup_id: str):
    if len(setup_id) != 32:
        raise BadRequestError("Invalid setup ID")
    ddb_key = f"setups#{setup_id}"
    response = table.get_item(Key={"id": ddb_key})
    if "Item" not in response:
        raise NotFoundError
    item = response["Item"]
    s3_key = item["s3_key"]
    data = json.loads(bucket.Object(s3_key).get()["Body"].read())
    return {"setups": data}


@app.post("/share/setups/create")
def create_setups():
    try:
        json_data = app.current_event.json_body
        data = CreateSetupsRequest(**json_data)
    except pydantic.ValidationError as e:
        print(e)
        raise BadRequestError(f"Invalid setup data.")
    setup_id = generate_id()
    s3_key = f"setups/{setup_id}"
    ddb_key = f"setups#{setup_id}"
    body = json.dumps(json_data["setups"]).encode("utf-8")
    if len(body) > MAX_SETUP_SHARE_DATA_SIZE:
        raise BadRequestError(f"Setup data is too large.")
    bucket.Object(s3_key).put(Body=body)
    table.put_item(
        Item={
            "id": ddb_key,
            "setups_name": data.name,
            "s3_key": s3_key,
        }
    )
    return {"id": setup_id}


@app.post("/share/setup/create")
def create_setup():
    try:
        json_data = app.current_event.json_body
        data = CreateSetupRequest(**json_data)
    except pydantic.ValidationError as e:
        print(e)
        raise BadRequestError(f"Invalid setup data.")
    setup_id = generate_id()
    img_s3_key = f"preview/{setup_id}.png"
    img_bucket.Object(img_s3_key).put(Body=base64.b64decode(data.preview_image))
    ddb_key = f"setup#{setup_id}"
    table.put_item(
        Item={
            "id": ddb_key,
            "parameters": data.parameters.dict(),
            "img_s3_key": img_s3_key,
            "img_width": data.preview_width,
            "img_height": data.preview_height,
        }
    )
    return {"id": setup_id, "url": f"{SHARE_BASE_URL}/to/{setup_id}"}


@app.get("/share/setup/get/<setup_id>")
def get_setup(setup_id: str):
    if len(setup_id) != 32:
        raise BadRequestError("Invalid setup ID")
    ddb_key = f"setup#{setup_id}"
    response = table.get_item(Key={"id": ddb_key})
    if "Item" not in response:
        raise NotFoundError
    item = response["Item"]
    if "parameters" not in item:
        s3_key = item["s3_key"]
        data = json.loads(bucket.Object(s3_key).get()["Body"].read())
    else:
        data = item["parameters"]
    return {"parameters": data}


@app.get("/to/<setup_id>")
def to_setup(setup_id: str):
    if len(setup_id) != 32:
        raise BadRequestError("Invalid setup ID")
    ddb_key = f"setup#{setup_id}"
    response = table.get_item(Key={"id": ddb_key})
    if "Item" not in response:
        raise NotFoundError
    item = response["Item"]
    img_s3_key = item["img_s3_key"]
    img_width = item["img_width"]
    img_height = item["img_height"]
    img_url = f"{IMG_BASE_URL}/{img_s3_key}"
    redirect_url = f"{SIM_BASE_URL}?load-setup={setup_id}"
    html = f"""<!DOCTYPE html>
<html prefix="og: https://ogp.me/ns#">
<head>
<meta property="og:title" content="Relight" />
<meta property="og:url" content="{redirect_url}" />
<meta property="og:type" content="website" />
<meta property="og:image" content="{img_url}" />
<meta property="og:image:width" content="{img_width}" />
<meta property="og:image:height" content="{img_height}" />
<meta property="og:image:type" content="image/png" />
<meta name="twitter:image:src" content="{img_url}" />
<meta name="twitter:card" content="summary_large_image" />
<meta name="twitter:title" content="Relight" />
<meta http-equiv="refresh" content="0; url={redirect_url}" />
</head>
<body>
</body>
</html>
"""
    return Response(200, content_type="text/html", body=html, headers={"Location": redirect_url})


def get_sync_data(user_id: str) -> dict:
    response = table.get_item(Key={"id": f"sync#{user_id}"})
    if "Item" not in response:
        return {}
    return response["Item"]


@app.get("/sync")
def get_sync():
    user_id = get_user_id()
    etag = app.current_event.get_header_value("If-None-Match")
    sync_data = get_sync_data(user_id)
    if etag == sync_data.get("version"):
        return Response(
            status_code=304,
            content_type=None,
            body=None,
            headers={"ETag": etag},
        )
    if "s3_key" not in sync_data:
        return {"data": {}}
    data = json.loads(bucket.Object(sync_data["s3_key"]).get()["Body"].read())
    return Response(
        status_code=200,
        content_type=content_types.APPLICATION_JSON,
        body=json.dumps({"data": data}),
        headers={"ETag": sync_data["version"]},
    )


@app.put("/sync")
def put_sync():
    user_id = get_user_id()
    sync_data = get_sync_data(user_id)
    if "id" not in sync_data:
        sync_data["id"] = f"sync#{user_id}"
        sync_data["s3_key"] = f"sync/{user_id.replace('|', '_')}"
    if_match = app.current_event.get_header_value("If-Match")
    if if_match and if_match != sync_data.get("version"):
        return Response(
            status_code=412,
            content_type=None,
            body=None,
        )
    data = json.dumps(app.current_event.json_body["data"]).encode("utf-8")
    if len(data) > MAX_SYNC_DATA_SIZE:
        raise BadRequestError(f"Sync data too large. Max size is {MAX_SYNC_DATA_SIZE} bytes.")
    version = hashlib.sha256(data).hexdigest()
    if version != sync_data.get("version"):
        s3_key = sync_data["s3_key"]
        bucket.Object(s3_key).put(Body=data)
        sync_data["version"] = version
    table.put_item(Item=sync_data)
    return Response(
        status_code=204,
        content_type=None,
        body=None,
        headers={"ETag": version},
    )


def lambda_handler(event: dict, context: LambdaContext) -> dict:
    return app.resolve(event, context)
