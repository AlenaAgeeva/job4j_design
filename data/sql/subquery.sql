CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);
insert into customers (first_name,last_name,age,country) values ('Ivan','Ivanov',45,'Russia');
insert into customers (first_name,last_name,age,country) values ('Sidor','Sidorov',5,'UK');
insert into customers (first_name,last_name,age,country) values ('Igor','Igorev',14,'USA');
insert into customers (first_name,last_name,age,country) values ('Sergey','Sergeev',18,'Canada');
insert into customers (first_name,last_name,age,country) values ('Klim','Klimov',22,'Serbiya');
insert into customers (first_name,last_name,age,country) values ('Dennis','Dennisov',37,'Moldova');
insert into customers (first_name,last_name,age,country) values ('Artem','Artemov',77,'Belarus');
insert into customers (first_name,last_name,age,country) values ('Mihail','Mihailov',67,'Turkey');
insert into customers (first_name,last_name,age,country) values ('Pavel','Pavlov',49,'KNDR');

--Выполните запрос, который вернет список клиентов, возраст которых является минимальным.
select * from customers where age = (select min(age) from customers);

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);
insert into orders(amount,customer_id) values(23,1);
insert into orders(amount,customer_id) values(238,2);
insert into orders(amount,customer_id) values(1,3);
insert into orders(amount,customer_id) values(134,4);
insert into orders(amount,customer_id) values(56,5);
insert into orders(amount,customer_id) values(2,6);
insert into orders(amount,customer_id) values(543,7);
insert into orders(amount,customer_id) values(87,8);

--Необходимо выполнить запрос, который вернет список пользователей, которые еще не выполнили ни одного заказа.
--Используйте подзапрос, для реализации Вам понадобится NOT IN.

select * from customers where id not in (select customer_id from orders);
