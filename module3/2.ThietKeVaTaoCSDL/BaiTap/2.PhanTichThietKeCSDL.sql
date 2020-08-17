drop database if exists carstore_database;
create database carstore_database;
use carstore_database;

create table offices(
office_code varchar(10) 	PRIMARY	KEY,
city varchar(50) not null,
phone varchar(50) not null,
address_line1 varchar(50) not null,
address_line2 varchar(50),
state varchar(50) not null,
country varchar(50) not null,
postal_code varchar(15) not null
);
create table employees(
employee_number int 	PRIMARY	KEY,
last_name varchar(50) not null,
first_name varchar(50) not null,
email varchar(100) not null,
job_title varchar(50) not null,
offices_office_code varchar(10),
FOREIGN	KEY	(offices_office_code) REFERENCES offices(office_code)

);
create table customer(
customer_number int PRIMARY	KEY,
customer_name varchar(50) not null,
contact_last_name  varchar(50) not null,
contact_first_name varchar(50) not null,
phone varchar(50) not null,
address_line1 varchar(50) not null,
address_line2 varchar(50),
city varchar(50) not null,
stata varchar(50) not null,
postal_code varchar(15) not null,
country varchar(50) not null,
credit_limit double,
employee_employee_number int,
FOREIGN	KEY	(employee_employee_number) REFERENCES employees(employee_number)

);
create table orders(
oder_number int 	PRIMARY	KEY,
order_date date not null,
required_date date not null,
shipped_date date not null,
`status` varchar(15),
comnent text,
quantity_oedered int not null,
price_each double not null,
customer_customer_number int,
FOREIGN	KEY	(customer_customer_number) REFERENCES customer(customer_number)
 );
create table Paynemts(
customer_number int PRIMARY	KEY,
check_number varchar(70) not null,
payment_date date not null,
amount double not null,
FOREIGN	KEY	(customer_number) REFERENCES customer(customer_number)

);
create table product_lines(
product_line varchar(50) PRIMARY	KEY,
text_description text,
image varchar(50)
);
create table Product(
product_code varchar(15) PRIMARY	KEY,
product_nane varchar(50) not null,
product_scale varchar(10) not null,
product_vendor varchar(50) not null,
product_description text not null,
quantity_inStock int not null,
buy_price double not null,
msrp int not null,
Product_lines_product_line varchar(50),
FOREIGN	KEY	(product_lines_product_line) REFERENCES product_lines(product_line)
);

create table orders_has_product(
Orders_oder_number int,
FOREIGN	KEY	(orders_oder_number) REFERENCES orders(oder_number),
product_product_code varchar(15),
FOREIGN	KEY	(product_product_code) REFERENCES product(product_code)
);
select*from customer;
select*from orders;
select*from paynemts;
select*from product;
select*from product_lines;
select*from employees;
select*from offices;