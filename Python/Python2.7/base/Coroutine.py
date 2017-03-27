#encoding=utf-8
def consumer():
    state = ''
    while True:
        message = yield state
        print('[消费者] 获取到 %s...' % message)
        state = 'OK'

def produce(c):
    c.send(None) # 相当于 c.next() , 此时代码会 执行 3,4,5行 然后停留在 yield
    count = 0
    while count < 5:
        count = count + 1
        print('[生产者] 提供 %s...' % count)
        res = c.send(count)
        print('[生产者] 消费者返回的信息: %s' % res)
    c.close()

c = consumer()
produce(c)