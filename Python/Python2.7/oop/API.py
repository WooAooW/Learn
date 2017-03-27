class Get(object):

    def __init__(self, path=''):
        self._path = path

    def __getattr__(self, arg):
        print('call __getattr__(%s)' % arg)
        return Get('%s/%s' % (self._path, arg))

    def __str__(self):
        return self._path

    def __call__(self, param):
        print('cal __call__(%s)' % param)
        return Get('%s/%s' % (self._path, param))

    __repr__ = __str__

print Get("server").status.user.timeline.list
print Get().users('Kiss').repos