import mysql.connector as mysql_connector
from speaker.common.config.application import mysql_config
# https://blog.naver.com/PostView.nhn?blogId=jwyoon25&logNo=221343770497&categoryNo=40&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView

class conn():
    def __init__(self):
        self.rows = '';
        self.cursor = '';
        self.connect = '';
        
    def _get_connection(self, dictionary):
        self.connect = mysql_connector.connect(** mysql_config);
        if(dictionary):
            self.cursor = self.connect.cursor(dictionary=True);
        else:
            self.cursor = self.connect.cursor(dictionary=False);
        
    def _query_check(self, query):
        print("mysql query : {}".format(query))
        return query
        
    def getExecuteAll(self, query, dictionary):
        self._get_connection( dictionary)
        self._query_check( query)
        
        try:
            self.cursor.execute(query)        # SELECT 문은 commit 이 필요가 없다.
            self.rows = self.cursor.fetchall()     # 하나의 row 씩 SELECT [tuple 형태]
            self.connect.commit()
            
            print(self.rows)
            self._close();
        except mysql_connector.Error as err:
            print("mysql 에러 발생: {}".format(err))
            
        return self.rows;
    
    def _close(self):
        if(self.cursor):
            self.cursor.close()
        if(self.connect):
            self.connect.close()
            
