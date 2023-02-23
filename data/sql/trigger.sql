--1) Триггер должен срабатывать после вставки данных, для любого товара и просто
--насчитывать налог на товар (нужно прибавить налог к цене товара).
--Действовать он должен не на каждый ряд, а на запрос (statement уровень)

create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.09
        where id = (select id from inserted);
       return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger statement_tax_after
after insert
on products
referencing new table as inserted
for each statement
execute procedure tax();

insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 1, 50);
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_3', 10, 150);

drop trigger statement_tax_after on products;

-- 2) Триггер должен срабатывать до вставки данных и насчитывать налог на товар (нужно прибавить налог к цене товара).
--Здесь используем row уровень.

create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.09
        where count > 0;
       return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger row_tax_before
before insert
on products
for each row
execute procedure tax();

insert into products (name, producer, count, price) VALUES ('product_2', 'producer_3', 23, 50);

drop trigger row_tax_before on products;

--3) Нужно написать триггер на row уровне, который при вставке продукта в таблицу products,
--будет заносить имя, цену и текущую дату в таблицу history_of_price.

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function price()
    returns trigger as
$$
    BEGIN
        insert into history_of_price (name, price, date)
        VALUES ((select name from inserted), (select price from inserted), CURRENT_DATE);
       return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger row_history_price_after
after insert
on products
referencing new table as inserted
for each row
execute procedure price();

insert into products (name, producer, count, price) VALUES ('product_2', 'producer_3', 23, 50);
