drop database if exists birdsquare;

create database birdsquare;

use birdsquare;

-- note: don't use indentations or shell script won't run
create table bird (
id int not null auto_increment,
common_name varchar(200) not null,
scientific_name varchar(200) not null,
family_name varchar(200) not null,
order_name varchar(200) not null,
PRIMARY KEY ( id )
);

create table user (
id int not null auto_increment,
name varchar(200) not null,
points int default 0,
PRIMARY KEY ( id )
);
