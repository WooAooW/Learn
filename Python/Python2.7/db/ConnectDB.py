#encoding=utf-8
import sqlite3

def createTable(connect):
    connect.execute("DROP TABLE IF EXISTS USER;")
    connect.execute('''
    CREATE TABLE USER
    (ID INT PRIMARY KEY     NOT NULL,
     NAME           TEXT    NOT NULL,
     AGE            INT     NOT NULL,
     INFO           CHAR(50),
     BRITH          DATE);
    ''')
    connect.commit()

def inseretData(connect):
    connect.execute("INSERT INTO USER (ID, NAME, AGE, INFO, BRITH) VALUES (1, '李瑜', 23, '工作中', '1993/05/02')")
    connect.execute("INSERT INTO USER (ID, NAME, AGE, INFO, BRITH) VALUES (2, '吕中', 25, '工作中', '1991/02/18')")
    connect.execute("INSERT INTO USER (ID, NAME, AGE, INFO, BRITH) VALUES (3, '张鹏', 27, '工作中', '1989/11/13')")
    connect.execute("INSERT INTO USER (ID, NAME, AGE, INFO, BRITH) VALUES (4, '李志刚', 24, '读研中', '1992/01/28')")
    connect.execute("INSERT INTO USER (ID, NAME, AGE, INFO, BRITH) VALUES (5, '屠绘林', 24, '工作中', '1992/04/18')")
    connect.commit()

if __name__ == "__main__":
    print "开始连接数据库..."
    conn = sqlite3.connect('test.db');

    print "开始创建表..."
    createTable(conn)

    print "开始插入数据..."
    inseretData(conn)

    print "获取数据..."
    res = conn.execute("SELECT * FROM USER")
    for row in res:
        print row
    conn.close()
