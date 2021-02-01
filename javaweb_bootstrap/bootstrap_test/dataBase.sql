https://ggfw.gdhrss.gov.cn/gwyks/anouns.do
// DML DDL DCL DQL

// rename password
//stop servicc
cmd->services.msc ->mysql ->stop
//skip grant
mysqld --skip-grant-tables
// new cmd window
mysql -u root -p // no input the password
// rename password
use mysql;
update user set password = password('123456') where user='root';
// kill mysqld 
// reboot mysql service


//0.login the database server
mysql -u root -p  //-h :host -p:port

//1. show  databases
show databases;

//2. show define the database info
show create database bjpowernode;

alter database bjpowernode character set utf8;
drop database db1;

//3. show current database
select database();

//4. switch the database 
use databaseName;

//5. basedata type
java   				mysql
byte/shot/int/long  tinyint/smallint/int/bigint
float				float
double				double
boolean				bit
char/String			char(no mutable string) or varchar（mutable string）
Date				data/time/datatime(default null)/timestamp(current system time)
File				BLOB/TEXT

//6. create table
create database web_data;
use web_data;
create table user(
id int primary key auto_increment,
username varchar(20) unique,
password varchar(20) not null,
age int,
birthay date
);

//7. show tables;
show tables;

//8.show table struct
desc user(table name);

//9.delete table
drop table user;

//10. modify table
//10.1   add to talbe column
alter table user add image varchar(100);

// 10.2 modify the column type , length 
alter table user modify image varchar(150);

//10.3 delete column
alter table user drop age;

//10.4 modify column names
alter table user change image avatar varchar(150);

//10.5 modify table name 
rename table user to employee;

//10.6 modify the table to set string collection  
alter table employee character set utf8;


//11.show database table string collection 
show variables like '%character%'
services.msc

// 12 .insert  
insert into user values(1,'孙小梅','123','2020-11-11',1);

// 13 update
update user set password='123',age=22 where username='aaa';

//14.delete all data 
delete from user;//DML, events restory => data:rollback;
trunc table user;//DDL,delete the table and new table that the same struct as the table

 //15. query _ or %
 // query the english score contains of 88,90,100 
 select *from exam where english in(88,90,100);
 
 // create exam talbe
 create table exam(
 id int primary key auto_increment,
 name varchar(20) unique,
 english float,
 chinese float,
 math float
 );
 insert into exam values(1,'孙小梅',90,90,100);
 select sum(english)+sum(chinese)+sum(math) from exam;
 select sum(ifnull(english,0)+chinese+math) from exma;
 
 // 16. visual tool :sqlyog
 create table dept(
 	did int primary key auto_increment,
 	dname varchar(20)
 );
 insert into dept values (null,'市场部');
 insert into dept values (null,'人事部');
 insert into dept values (null,'教研部');
 create table employee(
 	eid int primary key auto_increment,
 	ename varchar(20),
 	salary double,
 	birthday date,
 	sex varchar(10),
 	dno int
 );
 
 alter table employee modify dno int not null;
 
 insert into employee values (null,'张三',8000,'1988-09-01','男',3);
 insert into employee values (null,'李四',9000,'1988-09-01','男',1);
 insert into employee values (null,'王五',6000,'1988-09-01','男',2);
 insert into employee values (null,'赵六',10000,'1988-09-01','男',3);
 insert into employee values (null,'孙七',10000,'1988-09-01','男',1);
 //insert into employee values (null,'田八',10000,'1988-09-01','男',null);
 delete from dept where did = 2;
 alter table employee add foreign key (dno) references dept(did);