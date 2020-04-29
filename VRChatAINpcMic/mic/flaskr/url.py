from mic.test.apitest import apiTest
from mic.test.reintest import reinTest
from mic.reinforcement.learning.learning import learning

class API():
    def getList(self):
        return apiList;


apiList = [
    { 'name' : 'apiTest' , 'url' : '/test/api/test' , 'task' : apiTest},
    { 'name' : 'reinTest' , 'url' : '/test/rein/test' , 'task' : reinTest},
    { 'name' : 'learning' , 'url' : '/learining' , 'task' : learning},
]

