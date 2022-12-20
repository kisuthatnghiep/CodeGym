use quanlibanhang;
insert into Customer(cName, cage) values
('Minh Quan', 10),
('Ngoc Oanh', 20),
('Hong Ha', 50);
insert into order1(cID, oDate) values
(1, '2006-3-21'),
(2, '2006-3-23'),
(1, '2006-3-16');
insert into product(pname, pprice) values
('May Giat', 3),
('Tu Lanh', 5),
('Dieu Hoa', 7),
('Quat', 1),
('Bep Dien', 2);
insert into orderdetail(oid,pid,odQTY) values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
select * from order1;
select customer.cid,customer.cname,product.pname from customer
join order1 on customer.cid = order1.cid
join orderdetail on orderdetail.oid = order1.oid
join product on product.pid = orderdetail.pid;
select customer.cid, customer.cname from customer
where customer.cid not in (select order1.cid from order1);
select order1.oid, order1.odate, sum(product.pprice*orderdetail.odQTY) as totalPrice from order1
join orderdetail on order1.oid = orderdetail.oid
join product on product.pid = orderdetail.pid
group by orderdetail.oid;
update order1
set ototalPrice =(select sum(product.pprice*orderdetail.odQTY)from orderdetail
join product on product.pid = orderdetail.pid
where order1.oid = orderdetail.oid);