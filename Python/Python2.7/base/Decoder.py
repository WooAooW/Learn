#encoding=utf-8
import time

def log(text="执行时间",util="毫秒"):
    def decoder(func):
        def wrapper(*args, **kw):
            start = time.time() * 1000
            result = func(*args, **kw)
            end = time.time() * 1000
            print "%s:%f%s" % (text, (end - start), util)
            return result
        return wrapper
    return decoder

@log('time', 'ms')
def add(a, b):
    return a + b

@log()
def plus(a, b):
    return a + b

def more(a, b):
    return a + b

print add(1, 2)
print plus(3, 4)

print more(6, 8)
more = log("计算时间")(more)
print more(9, 10)