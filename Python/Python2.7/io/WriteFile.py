#encoding=utf-8

import os

#打开文件,以追加的形式写内容
with open("TestNumber.data", "a") as f:
    f.writelines("number=321")
    f.flush()
print "写出文件成功"
