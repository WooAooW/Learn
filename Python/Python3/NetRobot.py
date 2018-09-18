#-*_coding:utf8-*-
import requests
import re
import sys

class Robot(object):
    def __init__(self):
        print('开始爬取内容。。。')

#getsource获取网页源代码
    def getsource(self, url):
        html = requests.get(url)
        #print(html.text)
        return html.text

#geteverydiv抓取每个课程块的信息
    def getNextLink(self, source):
        nextLink = re.findall('<a href="(.*?)">.*?</a>',source,re.S)
        return nextLink

#getinfo从每个课程块中提取出课程标题和内容描述
    def getinfo(self,eachclass):
        info = {}
        info['title'] = re.search('<h3>(.*?)</h3>',eachclass,re.S).group(1)
        info['content'] = re.search('<p>(.*?)</p>',eachclass,re.S).group(1)
        #print info  可以在此打印，来检查是否抓到内容
        return info

#saveinfo用来保存结果到info.txt文件中
    def saveinfo(self,classinfo):
        f = open('info.txt','a')
        for each in classinfo:
            f.writelines('title:' + each['title'] + '\n')
            f.writelines('content:' + each['content'] + '\n\n')
        f.close()
        print("write file finished")

#主函数
if __name__ == '__main__':
    classinfo = []
    url = 'https://perso.esiee.fr/~baudoing/CD/Tutorial/'
    robot = Robot()
    print('正在处理页面：' + url)
    html = robot.getsource(url)
    nextLink = robot.getNextLink(html)
    print(nextLink)
    # for each in everydiv:
    #     info = robot.getinfo(each)
    #     classinfo.append(info)
    # robot.saveinfo(classinfo)