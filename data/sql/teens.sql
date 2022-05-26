create table teens(
id serial primary key,
name text,
gender character
);
insert into teens(name,gender) values('Sam','M');
insert into teens(name,gender) values('Amelia','F');
insert into teens(name,gender) values('Jack','M');
insert into teens(name,gender) values('Lidia','F');

select (t.name,t.gender),(t1.name,t1.gender) from teens t cross join teens t1
where t.gender!=t1.gender;