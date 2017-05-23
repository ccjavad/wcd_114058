create database if not exists java_test;

create table if not exists java_test.roles (
  role_name varchar(100) not null,
  constraint pkRole primary key(role_name)
);

create table if not exists java_test.users (
  user_name varchar(100) not null,
  user_pass varchar(100) not null,
  constraint pkUser primary key(user_name)
);

create table if not exists java_test.user_roles (
  user_name varchar(100) not null,
  role_name varchar(100) not null,
  primary key (user_name, role_name),
  constraint fkUser foreign key (user_name) references java_test.users(user_name),
  constraint fkRole foreign key (role_name) references java_test.roles(role_name)
);

insert into java_test.roles (role_name) values ('kunde');
insert into java_test.roles (role_name) values ('administrator');

insert into java_test.users (user_name, user_pass) values ('paul', 'paul');
insert into java_test.user_roles (user_name, role_name) values ('paul', 'kunde');

insert into java_test.users (user_name, user_pass) values ('mary', 'mary');
insert into java_test.user_roles (user_name, role_name) values ('mary', 'kunde');

insert into java_test.users (user_name, user_pass) values ('anton', 'anton');
insert into java_test.user_roles (user_name, role_name) values ('anton', 'administrator');
