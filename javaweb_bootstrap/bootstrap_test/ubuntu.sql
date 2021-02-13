 
1.reboot 
 2.shutdown -r now 立刻重启
 3.shutdown -r 10 过10分钟自动重启
 4.shutdown -r 20:35 在时间为20:35时候重启


redis-server  redis服务器
redis-cli redis命令行客户端
redis-benchmark redis性能测试工具
redis-check-aof AOF文件修复工具
redis-check-rdb  RDB文件检索工具

XSHELL 无法连接 虚拟机 Ubuntu16.04
1. 因为Ubuntu16.04 默认没有安装openssh-server
2. 在ubuntu服务器安装ssh服务。sudo apt-get install openssh-server
3.打开虚拟机终端，在命令行输入ifconfig，查询当前虚拟机的主机地址

Xshell 上传文件到Linux
1.通过Xshell终端连接Linux服务器，进入要上传文件目录，如文件上传到usr目录，则先进入usr目录
2.查看服务器是否支持rz上传文件：
输入rz命令、回车，如果支持则会弹出上传文件弹框；否则会提示找不到
3.不支持rz上传文件 则需先安装rz：输入yum -y install lrzsz、回车
4.安装成功后，再输入rz or rz -be命令、回车—弹出上传文件弹框，选择需要上传的本地文件 

5.在ubuntu 输入make命令提示以下的错误信息，说make没有安装
sudo apt-get install build-essential

6.xshell克隆会话
xshell克隆一个新的终端:shift + alt + t


7.给root用户设置密码
sudo passwd root
重新输入命令：su root


8. vi /usr/local/redis/redis.conf
//8. 1.local host
./bin/redis-cli -a admin 
/usr/local/redis/bin/redis-cli -h 127.0.0.1 -p 6379

//8.2.has password
/usr/local/redis/bin/redis-cli -h 192.168.164.128 -p 6397 -a admin

./bin/redis-server ./redis.conf

9. alt+E :show menu

//10. 关闭防火墙
service iptables stop

vi；:/keyword for search

/usr/local/redis/redis.conf

ps -ef | grep -i redis
kill -9 id 

//11.vi redis.conf
/requirepass 