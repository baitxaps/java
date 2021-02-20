# -*- coding: UTF-8 -*-



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
    print(a.strip().split("l").) # strip() =>delete the \n

stringOperator()    