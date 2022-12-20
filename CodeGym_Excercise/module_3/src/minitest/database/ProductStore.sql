create database SaleManager;
use SaleManager;
create table product(
id int not null primary key auto_increment,
code varchar(30) unique,
name varchar(50),
price double,
date_create datetime,
amount int
);
create table Customer(
id int not null primary key auto_increment,
name varchar(50),
age int,
address varchar(250)
);
create table Order1(
orderID int not null primary key auto_increment,
date_create datetime,
id int not null,
foreign key (id) references Customer(id)
);
create table OrderDetail(
orderID int not null,
id int not null,
quantity int,
foreign key (orderID) references order1(orderID),
foreign key (id) references product(id)
);
alter table customer modify age int check (age > 0 and age < 120);
insert into product(code, name, price, date_create, amount) value 
(1, 'shoes', 20, '2022-10-15', 4),
(2, 'T-shirt', 10, '2022-6-14', 2),
(3, 'toy', 5, '2022-3-17', 2),
(4, 'glasses', 8, '2022-10-15', 1);
insert into customer(name, age, address) value 
('Thanh', 23, 'Hà Đông'),
('Huy', 27, 'Khâm Thiên'),
('Tú', 18, 'Mỹ Đình');
insert into order1(date_create, id) value
('2022-11-15', 2),
('2022-11-12', 2),
('2022-11-2', 3);
insert into orderdetail(orderID, id, quantity) value
(7,1,2),
(7,1,1),
(9,3,2),
(8,2,1);

-- Hiển thị sản phẩm có số lượng cao nhất 
select * from product
where product.amount = (select Max(amount) from product);

-- Hiển thị các sản phẩm theo giá giảm dấn
select * from product
order by product.price DESC;

-- Hiển thị tổng tiền của tất cả order và mã order tương ứng
Select order1.orderID, sum(orderdetail.quantity*product.price) as totalPrice from order1
join orderdetail on order1.orderID = orderdetail.orderID
join product on orderdetail.id = product.id
group by orderdetail.orderID;

-- Hiển thị các sản phẩm có date_create trước ngày 10/7/2022
select * from product where product.date_create < '2022-7-10';

-- Hiển thị sản phẩm được mua nhiều nhất
select product.*, sum(orderdetail.quantity) as QualitySold from orderdetail
join product on orderdetail.id = product.id
group by orderdetail.id
having QualitySold >= all(select sum(orderdetail.quantity) from orderdetail group by orderdetail.id);