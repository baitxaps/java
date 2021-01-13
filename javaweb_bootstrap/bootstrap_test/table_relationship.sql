//1. 一对多的建表原则，
在多的一方创建外键指向一的一方主键。

//2.多对多建表原则，需要创建第三张表（中间表），
在中间表中至少两个字段分别作为外键，指向多对多双方的主键。

//3.一对一建表原则：
唯一外键对应的方式：假设一对一是一个一对多关系，
需要在多的一方创建外键指向一的一方主键将外键设置为唯一；
主键对应方式：两表主键一一对应。

//4.实现一个网上商城案例，在商城中会有用户，商品，订单，商品分类。


//5.连接查询
交叉连接：cross join(开发中很少用)
查询到的是两个表的笛卡尔积
select *from table1 cross join table2;
select *from table1,table2;

内连接:inner join(inner可以省略的)
显示内连接：在SQL中显示的调用inner join 关键字：
select *from table1 inner join table2 on condition expression
显示内连接：在SQL中没有显示的调用inner join 关键字：
select *from table1,table2 where condition expression

外连接:outer join(outer可以省略的)
左外连接：
select *from table1 left outer join table2 on conditon expression
右外连接：
select *from table right outer join table2 on condition expression

内外连接区别：
内连接：两个表相交部分
左外连接：左表与两个表相交部分
右名边接：右表与两个表相交部分

//6. 子查询：
一个查询语句条件需要依赖另一个查询语句的结果

//7. 查看隔离级别
select @@tx_isolation; // REPEATABLE-READ


// READ-UNCOMMITTED, READ-COMMITTED, REPEATABLE-READ, SERIALIZABLE.
set session transaction isolation level read uncommitted;

// A window start stansaction;
start stansaction;

//脏读：一个事务读到了另一个事务未提交的数据，导致查询结果不一致。
如何逸免：设计隔离级别为：set session transaction isolation level READ-COMMITTED

//不可重复读:一个事务读到了另一个事务已经提交的update的数据，
导致多次查询结果不一致（由更新数据引起）
//发现这次的结果已经发生了变化，已经发生不可重复读：

//如何逸免：设计隔离级别为：set session transaction isolation level REPEATABLE-READ
发现一个事务中的多次查询结果是一致的（已经避免不可重复读），
要想读到最新的数据，让事务结束 即：commit;

// 读虚/幻读数据:一个事务读到了另一个事务已经提交的insert的数据，
导致多次查询结果不一致 (由插入数据引用)

//如何逸免读虚/幻读数据 串行化：
设计隔离级别为 set session transaction isolation level SERIALIZABLE
一个A窗口插入，另一个B窗口等待,B事务提交或回滚，A起效







