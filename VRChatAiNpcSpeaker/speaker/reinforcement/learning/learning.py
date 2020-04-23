from flask_restful import Resource
from speaker.common.mariadb.connector import conn

class learning(Resource):
    def get(self):
        data = [];
        connector = conn()
        data.append(connector.getExecuteAll("select * from test", False))
        data.append(connector.getExecuteAll("select * from test", True))
        return data
    
    def post(self):
        return 1