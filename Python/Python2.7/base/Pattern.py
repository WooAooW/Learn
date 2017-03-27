#encoding=utf-8

# 导入re模块
import re

message = 'Hello Kiss This is Your Message. 1 + 1 = 2\n'
print message

# 字符串前面的 r 的意思是不会进行转义
message2 = r'Hello Kiss This is Your Message. 1 + 1 = 2\n'
print message2

# 将正则表达式编译成Pattern对象
pattern = re.compile(r'[a-z][a-zA-Z]*')

result = pattern.findall(message)
print result