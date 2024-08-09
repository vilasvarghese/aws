import pymysql

# RDS settings
endpoint = 'vilasdb.cruuvxu4nkuh.eu-west-1.rds.amazonaws.com'
db_name = 'classicmodels'
db_user_name = 'root'
password = 'Test'
#port = 3306

def lambda_handler(event, context):
    connection = pymysql.connect(
        host=endpoint,
        user=db_user_name,
        passwd=password,
        db=db_name)

    with connection.cursor() as cursor:
        cursor.execute('select * from customers')
        result = cursor.fetchall()

        for row in result:
            print("{0} {1} {2}".format(row[0], row[1], row[2]))
            
            
            