'''
 冒泡排序.
 核心思想: 数字大的往后靠.
 
 @see https://heleeos.com/blog/sorting-algorithm-theory.html#1冒泡排序
 @author liyu
 @version python 3.5.2
'''
import random

data = list(range(20))
random.shuffle(data)

print("数据:" + ",".join(str(s) for s in data))

for i in range(0, len(data) - 1):
    flag = False
    for j in range(0, len(data) - 1 - i):
        if(data[j] > data[j + 1]):
            flag = True
            data[j], data[j + 1] = data[j + 1], data[j]
    print("第{0}趟:{1}".format(i + 1, ",".join(str(s) for s in data)))
    if(flag == False):
        break

print("结果:" + ",".join(str(s) for s in data))
