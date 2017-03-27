#encoding=utf-8

#open("文件名", "打开方式") 打开文件
f = open("TestNumber.data", "r")
info = f.read()
f.close()
print info

#打开文件流 是有可能出现异常的
try:
    f2 = open("TestNumber.data", "r")
    info2 = f2.read()
    print info2
finally:
    f2.close()

#with 代替了finnaly 中的close()
with open("TestNumber.data", "r") as f3:
    info3 = f3.readlines()
    print info3
