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

// 10.2 modify the column type , lengh 
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

// 132.