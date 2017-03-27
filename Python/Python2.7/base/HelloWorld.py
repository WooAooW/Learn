#encoding=utf-8
#第一行声明文件的编码格式
#输出一句话
print 'Hello World'

#这是一条注释的内容

'''
这是多行
注释的内容
'''

"""
这也是多行
注释的内容
"""
age = 23
name = "kiss"

age2 = 22
name2 = "lzg"

if(age < age2):
    print "%s比%s小!" %(name,name2)
else:
    print "%s比%s大!" %(name,name2)

#Python 使用缩进来代替语句块{}