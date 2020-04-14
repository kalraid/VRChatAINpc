#-*- coding: utf-8 -*-
# main.py
from flask import Flask
from flask_restful import reqparse, abort, Api, Resource
from mic.flaskr.url import API
from mic.common.eureka.eureka_client import eureka_client_setting

app = Flask(__name__)
api = Api(app)


class CreateUser(Resource):
    def post(self):
        try:
            parser = reqparse.RequestParser()
            parser.add_argument('email', type=str)
            parser.add_argument('user_name', type=str)
            parser.add_argument('password', type=str)
            args = parser.parse_args()

            _userEmail = args['email']
            _userName = args['user_name']
            _userPassword = args['password']
            return {'Email': args['email'], 'UserName': args['user_name'], 'Password': args['password']}
        except Exception as e:
            return {'error': str(e)}

api.add_resource(CreateUser, '/user')

apiUrl = API.getList('');
for i in apiUrl:
    print(i["task"])
    print(i["url"])
    print(i["name"])
    api.add_resource(i["task"], i["url"]);



if __name__ == '__main__':
#     app.run(host='0.0.0.0', port = 8787, debug=True) 
    port = 8752
    service_name = "Mic"
    eureka_server = "http://localhost:8761/eureka"
    ec = eureka_client_setting();
    ec.client_init(eureka_server, service_name, port) 
    app.run(port=port, debug=True) 

    