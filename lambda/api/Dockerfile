FROM public.ecr.aws/lambda/python:3.9

COPY requirements.txt  .
RUN pip3 install -r requirements.txt --target "${LAMBDA_TASK_ROOT}"

COPY app.py ${LAMBDA_TASK_ROOT}
COPY utils ${LAMBDA_TASK_ROOT}/utils

CMD [ "app.lambda_handler" ]
