import json
import uuid

import boto3
import pydantic
from aws_lambda_powertools.event_handler import APIGatewayRestResolver, APIGatewayHttpResolver
from aws_lambda_powertools.event_handler.exceptions import BadRequestError, NotFoundError
from aws_lambda_powertools.utilities.typing import LambdaContext

from utils.models import CreatePresetsRequest

session = boto3.Session(region_name="us-west-2")
dynamodb = session.resource("dynamodb")
table = dynamodb.Table("relight-legacy-sharedata")
s3 = session.resource("s3")
bucket = s3.Bucket("relight-legacy-sharedata")

app = APIGatewayHttpResolver()


def generate_id() -> str:
    return uuid.uuid4().hex


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
    except pydantic.ValidationError:
        raise BadRequestError(f"Invalid preset data.")
    preset_id = generate_id()
    s3_key = f"presets/{preset_id}"
    ddb_key = f"presets#{preset_id}"
    bucket.Object(s3_key).put(Body=json.dumps(json_data["presets"]).encode("utf-8"))
    table.put_item(
        Item={
            "id": ddb_key,
            "presets_name": data.name,
            "s3_key": s3_key,
        }
    )
    return {"id": preset_id}


def lambda_handler(event: dict, context: LambdaContext) -> dict:
    return app.resolve(event, context)
