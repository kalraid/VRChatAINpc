import py_eureka_client.eureka_client as eureka_client


class eureka_client_setting():
    def __init__(self):
        print(self)
    
    def client_init(self, eureka_server, app_name, instance_port):
        eureka_client.init(eureka_server=eureka_server,
                   app_name=app_name,
                   instance_port=instance_port)

