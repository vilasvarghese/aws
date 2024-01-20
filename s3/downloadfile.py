import boto3

# AWS S3 details
aws_region = 'us-east-1'
aws_bucket = 'vilascmk'
aws_object_key = 'Actors.jpg'
            #https://vilascmk.s3.amazonaws.com/Actors.jpg



# Create an S3 client using the default credential provider chain
s3 = boto3.client('s3', region_name=aws_region)

response1 = s3.list_objects_v2(Bucket='vilascmk')
for obj in response1.get('Contents', []):
    print('Object Key:', obj['Key'])


# Specify the SSE-KMS parameters
sse_kms_params = {'SSEKMSKeyId': 'vilascmk'}

# Download the object
try:
    response = s3.get_object(Bucket=aws_bucket, Key=aws_object_key)#, SSEKMSKeyId='vilascmk'
    # File content is in response['Body'].read()
    file_content = response['Body'].read()
    print(file_content)
    print("Object downloaded successfully.")
except Exception as e:
    print(e)