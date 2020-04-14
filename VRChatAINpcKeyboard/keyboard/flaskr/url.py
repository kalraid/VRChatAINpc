from keyboard.test.apitest import apiTest
from keyboard.test.reintest import reinTest
from keyboard.reinforcement.learning.learning import learning

class API():
    def getList(self):
        return apiList;


apiList = [
    { 'name' : 'apiTest' , 'url' : '/test/api/test' , 'task' : apiTest},
    { 'name' : 'reinTest' , 'url' : '/test/rein/test' , 'task' : reinTest},
    { 'name' : 'learning' , 'url' : '/learining' , 'task' : learning},
]

