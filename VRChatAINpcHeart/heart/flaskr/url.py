from heart.test.apitest import apiTest
from heart.test.reintest import reinTest
from heart.reinforcement.learning.learning import learning

class API():
    def getList(self):
        return apiList;


apiList = [
    { 'name' : 'apiTest' , 'url' : '/test/api/test' , 'task' : apiTest},
    { 'name' : 'reinTest' , 'url' : '/test/rein/test' , 'task' : reinTest},
    { 'name' : 'learning' , 'url' : '/learining' , 'task' : learning},
]

