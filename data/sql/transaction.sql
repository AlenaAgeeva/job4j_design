--1) Добавьте произвольную таблицу, заполните ее произвольными данными.
--Поэкспериментируйте с данными в транзакциях с разными уровнями изоляции транзакций.
--Для уровня SERIALIZABLE добейтесь ошибки при выполнении одной из параллельных транзакций.
--Приложите в комментарий скриншот с последовательностью операций, а также выводом ошибки.

create table person (id serial primary key, name text, age integer, gender character );

insert into person(name, age, gender) values ('Name_1', 56, 'F');
insert into person(name, age, gender) values ('Name_2', 18, 'F');
insert into person(name, age, gender) values ('Name_3', 32, 'M');
insert into person(name, age, gender) values ('Name_4', 44, 'M');

begin transaction isolation level serializable;-- 1 terminal

begin transaction isolation level serializable;-- 2 terminal

update person set name = 'a' where id = 2; -- 1 terminal

update person set name = 'b' where id = 3; -- 2 terminal
commit;-- 2 terminal

commit ;-- 1 terminal ERROR