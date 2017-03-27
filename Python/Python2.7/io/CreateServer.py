#encoding=utf-8

#使用Python自带的WSGI处理函数,Web Server Gateway Interface
from wsgiref.simple_server import make_server

#定义一个处理请求的方法
#第一个参数是请求的参数集
#第二个参数是发送响应的函数
def doGet(param, response):
    response('200 OK', [('Content-Type', 'text/html')])
    res = '<h1>Hello, Python Server!</h1><br>Param:'
    for key in param:
        res = res  + key + " -> " + str(param[key]) + "<br>"
    return res

port = 23456
#启动服务器 指定地址,指定端口,指定请求的函数
httpd = make_server('127.0.0.1', port, doGet)
print "服务器已经启动,端口号%d" % port

httpd.serve_forever()