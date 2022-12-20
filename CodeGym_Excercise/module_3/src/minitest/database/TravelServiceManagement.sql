create database `TravelServiceManagement`;
use TravelServiceManagement;
create table Country(
countryID int auto_increment primary key,
countryName varchar(50)
);
create table Location(
locationID int auto_increment primary key,
countryID int not null,
LocationName varchar(50),
foreign key (countryID) references country(countryID)
);
create table Tour(
TravelID int auto_increment primary key,
locationID int not null,
foreign key (locationID) references Location(locationID),
price double,
numberOfDay int
);
create table Customer(
CCCD bigInt primary key,
CustomerName varchar(50),
CustomerAge int,
CustomerAddress varchar(50)
);
create table employee(
EmployeeID int auto_increment primary key,
EmployeeName varchar(50),
EmployeeAge int,
Salary int
);
create table service(
TravelID int not null,
CCCD bigInt not null,
EmployeeID int not null,
foreign key (TravelID) references Tour(TravelID),
foreign key (CCCD) references Customer(CCCD),
foreign key (EmployeeID) references employee(EmployeeID)
);
alter table service add primary key (TravelID, CCCD);
insert into Country(Countryname) values
('Vietnam'),
('Thailand'),
('USA'),
('Japan');
insert into Location(countryID, LocationName) values
(1,'Ha Noi'),
(1,'HCM'),
(2,'Bangkok'),
(3,'NYC'),
(3,'Los Angeles'),
(4,'Tokyo');
insert into tour(locationID, price, numberofday) values
(2,50,3),
(3,60,5),
(1,30,2),
(4,500,7),
(6,550,7),
(5,450,5);
insert into Customer(CCCD, CustomerName, customerAge, customerAddress) values
(011099003555,'Thanh',23,'Ha Dong'),
(011088003555,'Huy',25,'Kham Thien'),
(011077003555,'Tu',14,'My Dinh'),
(011066003555,'Lam',19,'Nam Tu Liem'),
(011055003555,'Quang',30,'Lang Ha'),
(011044003555,'Thanh',24,'Dong Da');
insert into employee(employeeName, employeeAge, salary) values
('Thanh',30,5000000),
('Trang',31,7000000),
('Thao',32,5000000),
('Quan',33,3000000),
('Linh',30,8000000),
('Thanh',30,9000000);
insert into service(TravelID,CCCD,EmployeeID) values
(1,011088003555,2),
(2,011099003555,1),
(3,011055003555,3),
(4,011077003555,4),
(5,011066003555,5),
(6,011044003555,6),
(2,011055003555,3),
(2,011077003555,4);
-- Hiện thị tất cả các chuyến đi của 1 nhân viên có mã theo yêu cầu
select tour.*, employeeName from tour
join service on service.TravelID = tour.TravelID
join employee on employee.EmployeeID = service.EmployeeID
where Service.employeeID = 3;
-- Hiển thị tất cả các chuyến đi của 1 khách hàng có cccd/cmt theo yêu cầu
select tour.*, customerName from tour
join service on service.TravelID = tour.TravelID
join customer on customer.CCCD = service.CCCD
where service.CCCD = 011055003555;
-- Hiển thị tất cả các chuyến đi của 1 thành phố có tên bất kỳ
select tour.*, countryName, locationName from tour
join location on tour.locationID = location.locationID
join country on location.countryID = country.countryID
where country.countryName = 'ThaiLand';
-- Hiển thị chuyến đi có đơn giá cao nhất
select tour.*, countryName, locationName from tour
join location on tour.locationID = location.locationID
join country on location.countryID = country.countryID
where price >= all(select price from tour);