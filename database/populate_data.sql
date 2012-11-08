use birdsquare;

insert into user (name) values ('abc');

load data local infile 'database/data.csv'
into table bird
fields terminated by ','
enclosed by '"'
lines terminated by '\n'
(common_name, scientific_name, family_name, order_name);



