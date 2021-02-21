import sys,os
#vscodeprint(a.center(50,"-"))
db_file="student_data.db"

def register_api():
    stu_data = {}#dict()
    print("welcome to small program".center(50,"_"))
    print("pls reister.")
    name = input("name:".strip())
    age = input("age:".strip())
    phone = input("phone:".strip())
    if phone in phone_list:
        exit("the phone registed.")

    id_card = input("id card:".strip())
    if id_card in id_card_list:
        exit("the id card registed.")
   

    course_list = ["python","linux","network safe"]
    for index,course in enumerate(course_list):
        print(f"{index}.{course}")

    selected_course = input("pls selected the course:")   
    if selected_course.isdigit():
        selected_course = int(selected_course)
        if selected_course >=0 and selected_course < len(course_list):
            picked = course_list[selected_course]
        else:
            exit("error selected.")    
    else:
        exit("error input.")  


    stu_data['name']=name  
    stu_data['age']=age 
    stu_data['phone']=phone 
    stu_data['id_card']=id_card    
    stu_data['course']=picked   
    return stu_data


def commit_to_db(filename,stu_data):
    f = open(filename,"a")
    row = f"{stu_data['name']},{stu_data['age']},{stu_data['phone']},{stu_data['id_card']},{stu_data['course']}\n"
    f.write(row)
    f.close()


def load_validated_data(filename):
    if os.path.exists(filename) and os.path.isfile(filename):
        f=open(filename,"r+")
        phone_list=[]
        id_card_list=[]
        for line in f:
            line = line.split(",")
            if len(line) >=3:
                phone=line[2]
                id_card=line[3]
                phone_list.append(phone)
                id_card_list.append(id_card)
        f.close()
        return phone_list,id_card_list

    return [],[]     

phone_list,id_card_list = load_validated_data(db_file)
stu_data =register_api() 
commit_to_db(db_file,stu_data)

print(stu_data)   

