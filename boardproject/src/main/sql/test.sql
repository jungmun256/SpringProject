select * from all_tables;

drop table sboard;
drop table smember;
create table sboard(
   bid int primary key,
   title varchar(30),
   writer varchar(30),
   content varchar(50),
   bdate date default sysdate,
   cnt int default 0,
   filepath varchar(100)
)

create table smember(
   mid varchar(30) primary key,
   password varchar(30),
   name varchar(30),
   role varchar(30)
);

select * from sboard;
select * from smember;
truncate table smember;

insert into smember values('kim','1234','사과','USER');