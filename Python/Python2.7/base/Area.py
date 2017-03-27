#encoding=utf-8
print("计算长方形面积!")
x = int(raw_input("请输入长度:"))
while(x <= 0 ):
    x = int(raw_input("请重新输入长度:"))
y = int(raw_input("请输入宽度:"))
while(y <= 0 ):
    y = int(raw_input("请重新输入宽度:"))
print("长方形的面积为:" + str(x * y))