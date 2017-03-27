#encoding=utf-8

def login(username, password):
    if(username == "kiss" and password == "123456"):
        print "登陆成功"
        return "SUCCESS"
    else:
        print "登陆失败"
        return "ERROR"

def deco(function):
    def _deco(username, password):
        print "[INFO] 调用登陆接口,username:%s,password:%s" % (username, password)
        return function(username, password)
    return _deco

user = raw_input("请输入用户名:")
word = raw_input("请输入密码:")


#原有的登陆模式
res = login(user, word)
print "原始模式,输出结果为:" + res

login = deco(login)
login(user, word)
print "装饰器模式,输出结果为:" + res