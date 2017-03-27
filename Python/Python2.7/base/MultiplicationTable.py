##encoding=utf-8

#打印乘法表
i = 1
while(i <= 9):
    j = 1
    while(j <= 9 and i >= j):
        print "%dX%d=%d" % (j, i, i*j),
        j = j + 1
    print ""
    i = i + 1

def dispLine(x):
    return x * x;
li = map(dispLine, [1, 2, 3, 4, 5, 6, 7, 8, 9])
print li

