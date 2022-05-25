create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);
insert into devices(name,price) values ('iphone',2000.5);
insert into devices(name,price) values ('ipad',5040.5);
insert into devices(name,price) values ('phone',500.7);
insert into devices(name,price) values ('tablet',2000.56);
insert into devices(name,price) values ('tv_station',10300.7);
insert into devices(name,price) values ('earphones',700.9);
insert into people(name) values ('Jon');
insert into people(name) values ('Sam');
insert into people(name) values ('Dean');
insert into people(name) values ('Bill');
insert into people(name) values ('Tom');
insert into people(name) values ('Jack');
insert into people(name) values ('William');
insert into people(name) values ('Ben');
insert into devices_people(device_id,people_id) values(1,1);
insert into devices_people(device_id,people_id) values(1,2);
insert into devices_people(device_id,people_id) values(1,3);
insert into devices_people(device_id,people_id) values(1,4);
insert into devices_people(device_id,people_id) values(1,7);
insert into devices_people(device_id,people_id) values(1,8);
insert into devices_people(device_id,people_id) values(1,5);
insert into devices_people(device_id,people_id) values(1,6);
insert into devices_people(device_id,people_id) values(2,6);
insert into devices_people(device_id,people_id) values(2,2);
insert into devices_people(device_id,people_id) values(2,1);
insert into devices_people(device_id,people_id) values(2,8);
insert into devices_people(device_id,people_id) values(2,3);
insert into devices_people(device_id,people_id) values(null,7);
insert into devices_people(device_id,people_id) values(4,2);
insert into devices_people(device_id,people_id) values(4,5);
insert into devices_people(device_id,people_id) values(5,5);
insert into devices_people(device_id,people_id) values(5,8);
insert into devices_people(device_id,people_id) values(5,1);
insert into devices_people(device_id,people_id) values(5,3);
insert into devices_people(device_id,people_id) values(5,6);
insert into devices_people(device_id,people_id) values(6,1);
insert into devices_people(device_id,people_id) values(6,8);
insert into devices_people(device_id,people_id) values(6,3);
insert into devices_people(device_id,people_id) values(6,4);

select avg(price) from devices;

select p.name, avg(d.price) as avg_price from devices_people as dp
join people as p on p.id = dp.people_id
join devices as d on d.id = dp.device_id
group by p.name;

select p.name, avg(d.price) as avg_price from devices_people as dp
join people as p on p.id = dp.people_id
join devices as d on d.id = dp.device_id
group by p.name
having avg(d.price)>5000;