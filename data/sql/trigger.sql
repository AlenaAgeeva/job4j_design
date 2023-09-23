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

CREATE OR REPLACE FUNCTION add_tax_to_product_after_st()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
        update products
        set price = price + price * 0.20
        where id = (select id from inserted);
       return new;
    END;
$BODY$;


CREATE TRIGGER after_st_tax_trigger
    AFTER INSERT
    ON products
    REFERENCING NEW TABLE AS inserted
    FOR EACH STATEMENT
    EXECUTE FUNCTION add_tax_to_product();

insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 1, 50);
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_3', 10, 150);

-- 2) Триггер должен срабатывать до вставки данных и насчитывать налог на товар (нужно прибавить налог к цене товара).
--Здесь используем row уровень.

CREATE OR REPLACE FUNCTION add_tax_to_product_before_row()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
new.price = new.price + new.price *0.20;
return new;
END;
$BODY$;

CREATE TRIGGER before_row_tax_trigger
    BEFORE INSERT
    ON products
    FOR EACH ROW
    EXECUTE FUNCTION before_insert_tax();

insert into products (name, producer, count, price) VALUES ('product_2', 'producer_3', 23, 50);

--3) Нужно написать триггер на row уровне, который при вставке продукта в таблицу products,
--будет заносить имя, цену и текущую дату в таблицу history_of_price.

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

CREATE OR REPLACE FUNCTION transfer_data()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
insert into history_of_price (name, price, date)
        VALUES (new.name, new.price, CURRENT_DATE);
        return new;
END;
$BODY$;


CREATE TRIGGER after_row_transfer_data_trigger
    AFTER INSERT
    ON products
    FOR EACH ROW
    EXECUTE FUNCTION transfer_data();

insert into products (name, producer, count, price) VALUES ('product_2', 'producer_3', 23, 50);