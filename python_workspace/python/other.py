# -*- coding: UTF-8 -*-
import os,sys
import shutil
#from django.contrib.auth import authenticate as auth

print(__file__) # 打印当前脚本路径

#modulePath = "c:\\Users\\chenhairong\\Desktop\\javaweb\\python_workspace\\python\\module"
path = os.path.dirname(__file__)
module_path = path +"\\module"
#print(module_path)
sys.path.append(module_path)

import rhc_module
from package2.pg import pg_module


def module():
    # makedirs,mkdir
    # os.makedirs(r"python\\a\\b\\c")
    if os.path.exists("test"):
        pass
    else: 
        os.mkdir("test")

   # sys.path -> get system evn ivar
   # sys.argv -> get Script parameters 

    #system -> exec shell cmd
    #os.system("uname")
    #os.system("ipconfig")

    # cwd,listdir
    cwd =os.getcwd()
    dir = os.listdir()
    print(f"cwd:{cwd},dir={dir}")

    #remove removedirs
    #cp file_test.py file_test_bak.py
    s = path +"\\file_test.py"
    d = path +"\\file_test_bak.py"
    try:
       shutil.copy(s,d)
    except IOError as e:
        print("Unable to copy file. %s" % e)
    except:
        print("Unexpected error:", sys.exc_info())

    os.remove(d)

    # get file properties
    pro = os.stat(s)
    print(pro)
    print(pro.st_size)
    print(os.path.getsize(s))
    #rename
    #os.rename(s,d)
    
    #pypi.org => 292,634 projects 2,401,871 releases 3,917,057 files 487,227 users
    #pip3 install python2-secrets

   # rhc_module.say()
   # print(sys.path)# 打印系统库路径
   # system("df -h")
module()




def call_back(x):
    return x**2

def compare(x):
    if x > 5:
        return x     

def innerFunction():
    #bool
    isB= bool(0)
    isB = bool(None)
    a = [1,0,1,1]
    isB = all(a) # all element be true  => true  
    print(isB)
    isB= any(a)
    print(isB) # any element be true =>true

    #chr
    isB = chr(65) # value to ascii. A
    print(isB) # A
    #ord
    isB = ord(isB)
    print(isB) # ascii to value. 65

    #dict
    isB = dict()
    print(isB)
    isB = dict(name = "rhc",age =11)
    print(isB)

    #打印当前程序的所有变量名
   # print(dir())
   # print(__file__)# print path
    print(locals()) # 打印作用域的所有变量名 & 变量值 

    #map,filter
    tmpList=list(range(10))
    res = map(call_back,tmpList) # no exec,call_back 只能一个参数
    for e in res: # exec
        print(e)
    res = filter(compare,tmpList)
    for e in res:
        print(e)

    # max 
    big = max(tmpList)    
    print(big,min(tmpList),sum(tmpList))

    # enumerate
    #for index,val in enumerate(range(10)):
    for index,val in enumerate(["alex","rhc"]):
        print(index,val)

    #str,type
    print(str(tmpList),type(str(tmpList)))    

    #zip
    z1=["alex","jack"]
    z2=["bg","racheal","cici"]
    for i in zip(z1,z2):
        #('alex', 'bg')
        #('jack', 'racheal')
        print(i)

    # evel,exec,compile
        

#innerFunction()

def std_register(name,age,*args,**kwargs):#args ->array,kwargs-> dict
    print(name,age,args,args[0],kwargs)
    print(kwargs.get("addr"))
    return name,True,age,args,kwargs

#stringOperatorarray = std_register("a",22,"M","Girl",addr="guangzhou",hometown="hunan")
#print(array)

# 常用字符串操作
def stringOperator():
    a = "alex li"
    print(a.center(50,"-"))
    print(a.endswith("li"))
    print(a.startswith("alex"))
    print(a.find("i"))
    print(a.isdigit()) 
    l=["a","b","peiqi"] 
    print("-".join(l))
    #a=a.replace("l","M",1)
    #print(a)
    print(a.strip().split("l")) # strip() =>delete the \n


#stringOperator()    