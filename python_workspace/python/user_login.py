
#Cannot edit in read-only editor:

#File ->preference->输入run code->找到Run code configuration,
#把whether to run code in Intergrated Terminal 勾上重启VSCode即可

accounts= {
    #"rhc"：["rhc","abc123!","1"],
}

path = r'python\account.db'
f = open(path,"r")
for line in f:
    line = line.strip().split(",")
    accounts[line[0]] = line
print(accounts) 

count = 0
while count<3:
    user = input("pls input username:").strip()
    if user not in accounts:
        print("no reginter...")
        continue
    passwd = input("pls input password:")
    if passwd == accounts[user][1]:
        print(f"welcome{user}... login success...")
    else:
        print("password is error...")
    count =+1

f.close()   