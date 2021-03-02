DROP TABLE IF EXISTS cargo;

create table cargo (
  id int primary key,
  customer integer not null,
  product varchar(50) not null,
  quantity integer not null
);

insert into cargo (id, customer, product, quantity) values (1, 1, 'cargo1', 2);
insert into cargo (id, customer, product, quantity) values (2, 1, 'cargo2', 2);
insert into cargo (id, customer, product, quantity) values (3, 1, 'cargo3', 2);
insert into cargo (id, customer, product, quantity) values (4, 2, 'cargo4', 2);
insert into cargo (id, customer, product, quantity) values (5, 4, 'cargo5', 2);
insert into cargo (id, customer, product, quantity) values (6, 4, 'cargo6', 2);
insert into cargo (id, customer, product, quantity) values (7, 4, 'cargo7', 2);
insert into cargo (id, customer, product, quantity) values (8, 4, 'cargo8', 2);
insert into cargo (id, customer, product, quantity) values (9, 4, 'cargo9', 2);
insert into cargo (id, customer, product, quantity) values (10, 4, 'cargo10', 2);
insert into cargo (id, customer, product, quantity) values (11, 4, 'cargo11', 2);
insert into cargo (id, customer, product, quantity) values (12, 4, 'cargo12', 2);
insert into cargo (id, customer, product, quantity) values (13, 4, 'cargo13', 14);
insert into cargo (id, customer, product, quantity) values (14, 4, 'cargo14', 2);
insert into cargo (id, customer, product, quantity) values (15, 4, 'cargo15', 2);

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id int  PRIMARY KEY not null,
  name varchar(25) not null,
  address varchar(40) not null,
  city varchar(20) not null,
  email varchar(30) not null
);

insert into customer (id, name, address, city, email) values (1, 'zhangsan', 'address1', 'nanjing', 'zhangsan@163.com');
insert into customer (id, name, address, city, email) values (2, 'lisi', 'address2', 'guangzhou', 'lisi@163.com');
insert into customer (id, name, address, city, email) values (3, 'wangwu', 'address3', 'shanghai', 'wangwu@163.com');
insert into customer (id, name, address, city, email) values (4, 'zhaoliu', 'address4', 'beijing', 'zhaoliu@163.com');
