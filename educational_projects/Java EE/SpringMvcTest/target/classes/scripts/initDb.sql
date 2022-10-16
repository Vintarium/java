create table if not exists customer (
id int  auto_increment primary key ,
name varchar(45) not null);


create table if not exists receipt(
id int  auto_increment primary key ,
customerId int not null,
totalPrice int ,
foreign key(customerId) references customer(id));

create table if not exists product (
id int  auto_increment primary key,
name varchar(45) not null,
price int not null);


create table if not exists receiptProduct(
receiptId int,
productId int,
foreign key (receiptId) references receipt(id),
foreign key (productId) references product(id));



insert into product values(default,'Paracetamol',10);
insert into product values(default,'Ibuprofen',20);
insert into product values(default,'Analgin',15);
insert into product values(default,'Aspirin',12);
insert into product values(default,'Lapiramid',8);
insert into product values(default,'Loratodin',22);
insert into product values(default,'Drotoverin',40);
insert into product values(default,'Mezim',52);

