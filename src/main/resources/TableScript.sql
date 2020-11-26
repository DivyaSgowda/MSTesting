CREATE DATABASE IF NOT EXISTS UserDB;
USE UserDB;
DROP TABLE IF EXISTS User;



--drop sequence hibernate_sequence;
--
--create sequence hibernate_sequence start with 1006 increment by 1;



create table User(
UID int(6) primary key,
firstname varchar(30) not null,
lastname varchar(30) not null
); 

insert into User values(123321,'Holly','Mcarthy');
insert into User values(456654,'Sharon', 'lein');
insert into User values(789987,'Gerry', 'hawk');


select * from User;


--
--commit;


	