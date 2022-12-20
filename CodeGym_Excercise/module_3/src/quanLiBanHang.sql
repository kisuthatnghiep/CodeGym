create database QuanLiBanHang;
use QuanLiBanHang;
create table Customer(
cID int not null primary key auto_increment,
cName varchar(50) not null,
cAge tinyint
);
create table Order1(
oID int not null primary key auto_increment,
cID int not null,
foreign key (cID) references Customer(cID),
oDate datetime,
oTotalPrice bigint
);
create table Product(
pID int not null primary key auto_increment,
pName varchar(50),
pPrice int
);
create table OrderDetail(
oID int not null,
pID int not null,
foreign key (oID) references Order1(oID),
foreign key (pID) references Product(pID)
);
alter table orderdetail add odQTY int;