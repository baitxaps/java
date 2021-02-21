import sys
# print(sys.argv)

# old_str = sys.argv[1]
# new_str = sys.argv[2]
# filename = sys.argv[3]
print(sys.argv)
old_str = sys.argv[1]
new_str = sys.argv[2]
filename = sys.argv[3]

#load into the ram
f = open(filename,"r+",encoding="utf-8")
data = f.read()

# count and replace
old_str_count = data.count(old_str)
new_data = data.replace(old_str,new_str)

# clear old file
f.seek(0)
f.truncate()

# save new data into fiel
f.write(new_data)

f.close()
print(f'''success replace the string '{old_str}'  to '{new_str}',count: {old_str_count}''')

#python file_replace.py  停止  stop note_bak.txt  

def test():
    f=open("Annotation.png","rb")
    for line in f:
        print(line)
    f.close()

    f=open("wb_file","wb")
    s="二进制写入"
    f.write(s.encode("utf-8"))
    f.seek(f.tell())
    #print(f.tell())

def replace_test():
    f=open("note_bak.txt","r+",encoding='UTF-8')
    # read data to memory 
    data = f.read()
    tmp = data.replace("stop","停止")
    #clear the file
    f.seek(0)
    f.truncate()# 截断文件

    #把内容写回硬盘
    f.write(tmp)
    f.close()
#replace_test()