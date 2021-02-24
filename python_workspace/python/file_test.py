
# coding=utf-8
import subprocess
import time
import chardet

#path = r'note.txt'
# f = open("note.txt",'rb')
# data = f.read()
# print(chardet.detect(data))

fw = open('note_bak.txt', 'w',encoding='UTF-8')
fr = open('note.txt', 'r',encoding='UTF-8')
fr.seek(0,0)
for each_line in fr:
    #print(each_line)
    fw.write(each_line)
    #print(each_line.decode('utf-8'))
fr.close()
fw.close()

def fileOperator():
    f = open("name_list",mode="w",encoding="utf-8")
    f.write("张三\n")
    f.write("alex\n")
    f.close()
fileOperator()

def codefunction():
    s="路飞"
    s.encode("gbk")
    print(s)
#codefunction()

# fw = open('note_bak.txt', 'a',encoding='UTF-8')
# fr = open('note.txt', 'r',encoding='UTF-8')
# while True:
#     line = fr.readline().encode()
#     type = chardet.detect(line) #获取文件编码
#     #text = line.d
#     if line:
#         #time.sleep(1) # 休眠1秒
#         p = line.decode(type["encoding"])
#         print(p)
#         fw.write(p)
# fr.close()   
# fw.close()         