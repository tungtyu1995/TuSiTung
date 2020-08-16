drop database if exists carstore_database;
create database carstore_database;
use carstore_database;

create table Offices(
officeCode varchar(10) 	PRIMARY	KEY,
city varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50),
state varchar(50) not null,
country varchar(50) not null,
postalCode varchar(15) not null
);
create table Employees(
employeeNumber int 	PRIMARY	KEY,
lastName varchar(50) not null,
firstName varchar(50) not null,
email varchar(100) not null,
jobTitle varchar(50) not null,
Offices_officeCode varchar(10),
FOREIGN	KEY	(Offices_officeCode) REFERENCES Offices(officeCode)

);
create table Customer(
customer_Number int PRIMARY	KEY,
customer_Name varchar(50) not null,
contactLastName  varchar(50) not null,
contactFirstName varchar(50) not null,
phone varchar(50) not null,
address_Line1 varchar(50) not null,
address_Line2 varchar(50),
city varchar(50) not null,
stata varchar(50) not null,
postal_Code varchar(15) not null,
country varchar(50) not null,
credit_Limit double,
Employee_employeeNumber int,
FOREIGN	KEY	(Employee_employeeNumber) REFERENCES Employees(employeeNumber)

);
create table Orders(
oderNumber int 	PRIMARY	KEY,
orderDate date not null,
requiredDate date not null,
shippedDate date not null,
`status` varchar(15),
comnent text,
quantityOedered int not null,
priceEach double not null,
Customer_customer_Number int,
FOREIGN	KEY	(Customer_customer_Number) REFERENCES Customer(customer_Number)
 );
create table Paynemts(
customer_Number int PRIMARY	KEY,
checkNumber varchar(70) not null,
paymentDate date not null,
amount double not null,
FOREIGN	KEY	(customer_Number) REFERENCES Customer(customer_Number)

);
create table Productlines(
productLine varchar(50) PRIMARY	KEY,
textDescription text,
image varchar(50)
);
create table Product(
productCode varchar(15) PRIMARY	KEY,
productNane varchar(50) not null,
productScale varchar(10) not null,
productVendor varchar(50) not null,
productDescription text not null,
quantityInStock int not null,
buyPrice double not null,
MSRP int not null,
Productlines_productLine varchar(50),
FOREIGN	KEY	(Productlines_productLine) REFERENCES Productlines(productLine)
);

create table Orders_has_Product(
Orders_oderNumber int,
FOREIGN	KEY	(Orders_oderNumber) REFERENCES Orders(oderNumber),
Product_productCode varchar(15),
FOREIGN	KEY	(Product_productCode) REFERENCES Product(productCode)
);
select*from Customer;
select*from Orders;
select*from Paynemts;
select*from Product;
select*from Productlines;
select*from Employees;
select*from Offices;