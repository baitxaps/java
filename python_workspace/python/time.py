import time
import datetime
import random

def test_random():
    r1=random.randrange(1,10) #[1,10)
    r2=random.randint(1,10) #[1,10]
    r3=random.randrange(0,10,2) #[1,10)的偶數
    r4=random.random()# float
    r5=random.choice('abce3#$@1') #数据集返回随机字符
    r6=random.sample('abcdefthij',3)# 从多个字符中选取特定数量的字符
    r7=random.shuffle([0,1,3,4,5,6,7])#洗牌
    print(r1,r2,r3,r4,r5,r6,r7)

def test_time():
    s_time = time.time()
    #time.sleep(5)
    print(f"cost {time.time()-s_time}")

    #time.struct_time(
    # tm_year=2021, 
    # tm_mon=2, tm_mday=21, tm_hour=20,
    #  tm_min=59, tm_sec=39, tm_wday=6,
    #  tm_yday=52, tm_isdst=0
    # )
    t=time.localtime()
    print(t)# 将一个时间戳转换为当前时区的struct_time

    print(time.mktime(t)) #struct_time->unixtime
    print(time.strftime("%Y-%m-%d %X",time.localtime()))#struct_time->string

    time_str =time.strftime("%Y-%m-%d %H:%M:%S")# %p
    print(time_str)
    print(time.strptime(time_str,"%Y-%m-%d %H:%M:%S")) # string ->struct_time

def test_datetime():
    d = datetime.datetime.now()

    #time.struct_time(tm_year=2021, tm_mon=2, 
    # tm_mday=21, tm_hour=21, tm_min=26, tm_sec=24, 
    # tm_wday=6, tm_yday=52, tm_isdst=-1)
    print(d.timetuple())

    print(d+datetime.timedelta(5))# 2021-02-26 21:26:24.740112
    print(d+datetime.timedelta(-5,hours=5))# 2021-02-26 21:26:24.740112
    print(d.replace(year=2120,month=8))

#test_datetime()
test_random()