CentOS 7 64 :root/0000  admin/0000
Ubuntu 64 :rhc/123456

https://www.docin.com/p-318886438.html

程序员技术练级攻略
https://coolshell.cn/articles/4990.html

https://blog.csdn.net/HelloEarth_/article/details/104621246
下半年考试日期为11月6、7日

快速排序
https://blog.csdn.net/chengqiaoyahaixuyush/article/details/38273893

https://www.runoob.com/linux/linux-vim.html

//mac:
./configure --prefix=/usr/local/ffmpeg --enable-dubug=3
make -j 4
make install

// windows:
Cygwin(Cygnus Windows)
MinGW(Minimalist GNU for Windows)
VS(Visual Studio 2015/2017)
MSYS2(Minimal SYstem 2)



vs2015=>QT5.9
qt-vsaddin-msvc2015-2.2.1vsix

vs2015企业版KEY：
HM6NR-QXX7C-DFW2Y-8B82K-WTYJV




413, DBS
15,Software design

ubantu 64:(account:rhc  pwd:123456)

git clone https://git.ffmpeg.org/ffmpeg.git
libavfilter：音视频后期处理
libavdevice: 音视频设备做处理，音视频采集
libavresample:音频重采样, 移植过来的库，用的较少
libswresample:对音频的操作
libswscale:对视频的操作

./configure --list-decoders
./configure --list-encoders

./configure --prefix=/usr/local/ffmpeg --enable-gpl --enable-nonfree
--enable-debug --disable-optimizations --enable-libspeex
--enable-videotoolbox --enable-shared --enable-pthreds
--enable-version3 --enable-hardcoded-tables
--cc=clang --host-cflags=--host-ldflags=

make && make install
ffprobe:多媒体侦测
exec:
/usr/local/ffmpeg/bin/ffmpeg

vi ~/.bash_profile:
unset PKG_CONFIG_PATH
export PKG_CONFIG_PATH=$PKG_CONFIG_PATH:/usr/local/lib/pkgconfig:/usr/lib/pkgconfig:/usr/local
/SDL2/lib/pkgconfig:/usr/local/ffmpeg/lib/pkgconfig
export PATH=$PATH:/usr/local/ffmpeg/bin

ffmpeg命令分类：
1、基本信息查询命令：裁剪与合并命令
2、录制命令：图片/视频互转命令
3、分解/复用命令：直播相关命令
4、处理原始数据命令：各种滤镜命令



1.音视频基础+ffmpeg原理+项目实战 一课完成音视频技术开发入门(实战 入门￥288.00)
(编程必备基础-音视频小白系统入门课普适所有方向程序员，系统补足你缺乏的音视频基础知识)

2.经典再升级-FFmpeg音视频核心技术全面精讲+实战
3.WebRTC实时互动直播技术入门与实战 5G时代必备技能
4.百万级高并发WebRTC流媒体服务器设计与开发(实战 高级 ￥366.00)
5.OpenCV入门到进阶：实战三大典型项目(车辆检测/人脸识别+图像拼接+文字识别)
6小时玩转音视频编辑与特效


swift -OC 运行时
纺译原理：启动优化，缩小安装包
各种原理：明白，二制制重排，常用算法
https://time.geekbang.org/column/article/85331
https://github.com/ming1016
https://52doc.com/detail/78920
https://www.jianshu.com/p/92690a240fce
http://sharing-pdf.jscinmark.ru/zh-CN/download_file_sharing/
gen_dai_ming_xue_iosbian_cheng_li_shun_he_xin_zhi_shi_dian__21562_zip?language=zh-CN

截屏:Windows + Shift + S 
微软拼音输入法切换简繁体：按ctrl+shift+f

Nginx
Nginx(engine x）是一个高性能的HTTP和反向代理服务器，
也是一个IMAP/POP3/SMTP服务器。
Nginx是由Igor Sysoev为俄罗斯访问量第二的Rambler.ru站点开发的
负载均衡服务器分为两种：
一种是通过硬件实现的负载均衡服务器，简称硬负载
另一种是通过软件来实现的负载均衡，简称软负载

Nginx应用场景
1、http服务器，可以做静态网页的http服务器。
2、配置虚拟机。
一个域名可以被多个ip绑定。可以根据域名的不同请求转发给运行在不同端口的服务器。
3、反向代理，负载均衡。把请求转发给不同的服务器。

正向代理它隐藏了客户端
反向代理它隐藏是服务器端
nginx: /usr/sbin/nginx /etc/nginx /usr/share/nginx

4. cmd
boot: 					nginx 		=>./nginx
stop(相当于找到nginx进程kill): 			nginx -s stop	=>./nginx -s stop
quit(等程序执行完毕后关闭，建议使用此命令): 	nginx -s quit
reload(可以不关闭nginx的情况下更新配置文件): 	nginx -s reload
ps -ef | grep nginx

 重启命令：
1.reboot 
2.shutdown -r now 立刻重启
3.shutdown -r 10 过10分钟自动重启	
4.shutdown -r 20:35 在时间为20:35时候重启

关机命令：
1.halt   立刻关机
2.poweroff  立刻关机
3.shutdown -h now 立刻关机(root用户使用)
4.shutdown -h 10 10分钟后自动关机
如果是通过shutdown命令设置关机的话，可以用shutdown -c命令取消重启


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


【第一章 操作系统概述】(https://blog.csdn.net/weixin_44075132/article/details/116407566)
【第二章 进程管理】(https://blog.csdn.net/weixin_44075132/article/details/116431430)
【第二章 进程同步和互斥】(https://blog.csdn.net/weixin_44075132/article/details/116503739)
【第二章 死锁】(https://blog.csdn.net/weixin_44075132/article/details/116544068?spm=1001.2014.3001.5501)
【第三章 内存管理】(https://blog.csdn.net/weixin_44075132/article/details/115981474)
【第四章 文件管理 】(https://blog.csdn.net/weixin_44075132/article/details/116135650)
【第五章 磁盘管理】(https://blog.csdn.net/weixin_44075132/article/details/116205733)
【第六章 设备管理 】(https://blog.csdn.net/weixin_44075132/article/details/116247358)

将内存空间分为一个个大小相等的分区( 比如:每个分区4KB)，
每个分区就是一个“页框”，或称“页帧”、“内存块”、“物理块”。
每个页框有一个编号，即“页框号”(或者“内存块号”、“页帧号”、“物理块号”)页框号从0开始
将用户进程的地址空间也分为与页框大小相等的一个个区域，称为“页”或“页面”。每个页面也有一个编号，即‘页号”,页号也是从0开始。
(注:进程的最后一个页面可能没有一个页框那么大。因此，页框不能太大，否则可能产生过大的内部碎片)
各个页面不必连续存放，也不必按先后顺序来，可以放到不相邻的各个页框中。



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

//12.
#if defined(WIN32) && !defined(__MINGW32__) && !defined(__CYGWIN__)
#      define CONFIG_WIN32
#endif
#if defined(WIN32) && !defined(__MINGW32__) && !defined(__CYGWIN__) && !defined(EMULATE_INTTYPES)
#      define EMULATE_INTTYPES
#endif
#ifndef EMULATE_INTTYPES
#     include <inttypes.h>
#else
      typedef signed char    int8_t;
      typedef signed short int16_t;
      typedef signed int     int32_t;
      typedef unsigned char    uint8_t;
      typedef unsigned short uint16_t;
      typedef unsigned int     uint32_t;
#     ifdef CONFIG_WIN32
          typedef signed __int64     int64_t;
          typedef unsigned __int64 uint64_t;
#     else /* other OS */
          typedef signed long long     int64_t;
          typedef unsigned long long uint64_t;
#     endif /* other OS */
#endif /* EMULATE_INTTYPES */

解决办法：
项目——属性——C/C++——预处理器——预处理器定义——右侧下拉框中
“编辑”——在第一个编辑框中添加_CRT_SECURE_NO_WARNINGS——大功告成