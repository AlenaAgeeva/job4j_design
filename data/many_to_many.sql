create table subject(
	id serial primary key,
	name varchar(55)
);
create table grade(
	id serial primary key,
	name varchar(55)
);
create table student(
	id serial primary key,
	name varchar(255),
	subject_id int references subject(id),
	grade_id int references grade(id)
);
insert into subject (name) values ('Mathematics');
insert into subject (name) values ('Physics');
insert into subject (name) values ('Chemistry');
insert into grade (name) values ('A');
insert into grade (name) values ('B');
insert into grade (name) values ('C');
insert into grade (name) values ('D');
insert into student (name,subject_id,grade_id) values ('Sam',1,3);
insert into student (name,subject_id,grade_id) values ('Tom',2,1);
insert into student (name,subject_id,grade_id) values ('Will',3,2);
insert into student (name,subject_id,grade_id) values ('Kris',1,1);
