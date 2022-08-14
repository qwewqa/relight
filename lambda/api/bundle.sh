#!/usr/bin/env sh
rm api.zip
cd ./venv2/lib/python3.10/site-packages || exit
zip -r ../../../../api.zip .
cd ../../../../
zip -gr api.zip lambda_function.py utils
