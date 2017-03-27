#encoding=utf-8

class Field(object):
    def __init__(self, name, column_type):
        self.name = name
        self.column_type = column_type
    def __str__(self):
        return '<%s:%s>' % (self.__class__.__name__, self.name)
class StringField(Field):
    def __init__(self, name):
        super(StringField, self).__init__(name, 'varchar(100)')
class IntegerField(Field):
    def __init__(self, name):
        super(IntegerField, self).__init__(name, 'int')

class ModelMetaclass(type):
    def __new__(cls, name, bases, dct):
        if name=='Model':
            return type.__new__(cls, name, bases, dct)
        print('Found model: %s' % name)
        #print("cls:%s,name:%s,bases:%s,dct:%s" % (cls, name, bases, dct))
        mappings = dict()
        for k, v in dct.items():
            if isinstance(v, Field):
                print('Found mapping: %s ==> %s' % (k, v))
                mappings[k] = v
        for k in mappings.keys():
            dct.pop(k)
        dct['__mappings__'] = mappings # 保存属性和列的映射关系
        dct['__table__'] = name # 假设表名和类名一致
        return type.__new__(cls, name, bases, dct)
class Model(dict):
    __metaclass__ = ModelMetaclass

    def __init__(self, **kw):
        print "call init"
        super(Model, self).__init__(**kw)
    def __getattr__(self, key):
        try:
            return self[key]
        except KeyError:
            raise AttributeError(r"'Model' object has no attribute '%s'" % key)
    def __setattr__(self, key, value):
        self[key] = value
    def save(self):
        fields = []
        params = []
        args = []
        for k, v in self.__mappings__.items():
            fields.append(v.name)
            params.append('?')
            args.append(getattr(self, k, None))
        sql = 'insert into %s (%s) values (%s)' % (self.__table__, ','.join(fields), ','.join(params))
        print('SQL: %s' % sql)
        print('ARGS: %s' % str(args))
class User(Model):
    id = IntegerField('uid')
    name = StringField('username')
    email = StringField('email')
    password = StringField('password')

u = User(id=12345, name='Michael', email='test@orm.org', password='my-pwd')
u.save()