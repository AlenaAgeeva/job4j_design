--1)За основу возьмите таблицу, с которой мы работали в описании. В описании мы рассмотрели вариант вставки данных, изменения данных.
--Добавьте процедуру и функцию, которая будет удалять записи.
--Условия выбирайте сами – удаление по id, удалить если количество товара равно 0 и т.п.

create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace procedure delete_data(i_id integer)
language 'plpgsql'
as $$
    BEGIN
    delete from products where id = i_id;
    END
$$;

insert into products (name, producer, count, price) values ('product_1','producer_2', 70, 120);

call delete_data(1);

create or replace function f_delete_data(i_count integer, i_price integer)
returns void
language 'plpgsql'
as $$
    BEGIN
            delete from products where count < i_count and price < i_price;

    END;
$$;

insert into products (name, producer, count, price) values ('product_1','producer_2', 10, 40);
insert into products (name, producer, count, price) values ('product_1','producer_2', 25, 100);
insert into products (name, producer, count, price) values ('product_1','producer_2', 100, 49);

select f_delete_data(25, 50);