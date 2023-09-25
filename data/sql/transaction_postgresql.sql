--1) По аналогии с описанием выполните транзакцию с несколькими точками сохранения.
--Поэкспериментируйте с откатом изменений к разным точкам сохранения.
--В комментарий приложите скриншот консольного вывода выполнения Ваших команд.

create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);
begin;
savepoint first_sp;
select * from products;
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 15, 32);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
savepoint second_sp;
select * from products;
delete from products where id < 2;
select * from products;
rollback to second_sp;
update products set count = 100 where price > 10;
select * from products;
rollback to first_sp;
select * from products;
commit;


