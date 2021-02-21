
#vscode:
# Cannot edit in read-only editor:

#File ->preference->输入run code->找到Run code configuration,
#把whether to run code in Intergrated Terminal 勾上重启VSCode即可

accounts= {
    #"rhc"：["rhc","abc123!","1"],
}

path = r'python\account.db'
fr = open(path,"r")
for line in fr:
    line = line.strip().split(",")
    accounts[line[0]] = line
print(accounts) 


while True:
    user = input("pls input username:").strip()
    if user not in accounts:
        print("no reginter...")
        continue
    elif accounts[user][2] == "1":
        print("the account on locked,pls contact with the manager")
        continue
    
    count = 0
    while  count<3:
        passwd = input("pls input password:")
        if passwd == accounts[user][1]:
            print(f"welcome{user}... login success...")
            exit("bye.")
        else:
            print("password is error...")
        count += 1
    if count ==3:
        print(f"you input {count} password,lock the {user}.")
        accounts[user][2] = "1"
        fw = open(path,"w")
        for user,val in accounts.items():
            line = ",".join(val) +"\n"
            fw.write(line)    
        fw.close()
        exit("bye.")
fr.close()   












