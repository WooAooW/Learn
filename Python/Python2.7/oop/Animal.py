##encoding=utf-8

def Run(canRun):
    canRun.run()

class Animal():
    def run(self):
        print "动物在跑"

a1 = Animal()
a1.run()

class Dog():
    def run(self):
        print "小狗在跑"

class Cat(Animal):
    pass

d1 = Dog()
d1.run()

c1 = Cat()
c1.run()

Run(a1)
Run(d1)
Run(c1)

print type(a1)
print type(d1)
print type(c1)

print isinstance(a1, Animal)
print isinstance(d1, Animal)
print isinstance(c1, Animal)

print dir(a1)
print dir(d1)
print dir(c1)