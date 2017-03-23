drop table if exists person;
create table person
(
   id  varchar(32) not null,
   name  varchar(256) character set utf8,
   primary key (id)
);

insert into person(id,name) values("007","邦德");