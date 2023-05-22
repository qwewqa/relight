import zipfile
from pathlib import Path

# Run `pip install --platform=manylinux1_x86_64 --only-binary=:all: --python-version 3.8 -r requirements.txt -t ./deps`
DEPENDENCIES = "deps"

EXCLUDED_PACKAGES = [
    "boto3",
    "botocore",
    "pip",
    "setuptools",
]

APP_PATHS = [
    "utils",
    "lambda_function.py",
]


def write_to_zip(zip_file: zipfile.ZipFile, base: Path, path: Path = None):
    if path is None:
        path = base
    if path.is_dir():
        for child in path.iterdir():
            write_to_zip(zip_file, base, child)
    else:
        zip_file.write(path, path.relative_to(base))


def package_for_lambda():
    with zipfile.ZipFile("lambda.zip", "w") as zip_file:
        for path in APP_PATHS:
            write_to_zip(zip_file, Path(__file__).parent, Path(__file__).parent / Path(path))
        for path in Path(DEPENDENCIES).iterdir():
            if any(path.name.startswith(excluded) for excluded in EXCLUDED_PACKAGES):
                continue
            write_to_zip(zip_file, Path(DEPENDENCIES), path)


if __name__ == "__main__":
    package_for_lambda()
