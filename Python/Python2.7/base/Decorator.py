#encoding=utf-8

def info():
    print "调用Info"
    return "info()"

print "---普通模式---"
res = info()
print "调用结果为:" + res
print "--------------"

def decoInfo(function):
    print "[DEBUG] 调用函数之前"
    return function

print "---装饰器模式---"
info2 = decoInfo(info)
print "--- 完成装饰 ---"
res = info()
res2 = info2()
print "调用结果为:" + res
print "调用结果为:" + res2
print "----------------"
