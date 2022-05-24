create table card(
id serial primary key,
num int,
date date
);
create table usersall(
id serial primary key,
name text,
card_id int references card(id)
);
insert into card (num,date) values(123,'1995-08-08');
insert into card (num,date) values(443,'2013-09-01');
insert into card (num,date) values(000,'2000-08-08');
insert into card (num,date) values(367,'2021-08-08');
insert into usersall (name,card_id) values('Sam',1);
insert into usersall (name,card_id) values('William',2);
insert into usersall (name,card_id) values('Jack',4);
insert into usersall (name,card_id) values('Ben',3);
insert into usersall (name) values('Tom');
insert into usersall (name) values('Jon');
select u.num, u.date, uu.name, uu.id from card as u join usersall as uu on u.id = uu.card_id;
select * from card as u join usersall as uu on u.id = uu.card_id;
select u.num, uu.name from card as u join usersall as uu on u.id = uu.card_id where u.id > 2;
