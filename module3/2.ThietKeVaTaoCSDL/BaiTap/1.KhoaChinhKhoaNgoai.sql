drop database if exists bank_database;
create database bank_database;
use bank_database;
-- Bảng Customers - khách hàng gồm customer_number , fullname , address , email, phone .
create table Customer (
customer_number int not null unique,
fullname varchar(255) not null,
address varchar(255) not null,
email varchar(255) not null,
phone int not null
);
-- Bảng Accounts -account_number , account_type , date , balance (số dư).
create table Accounts (
account_number int not null unique,
account_type varchar(255) not null,
`date` date not null,
balance double not null,
customer_number int, 
foreign key (customer_number)	references Customer(customer_number)

);
-- Bảng Transactions - tran_number (mã giao dịch), account_number (số tài khoản giao dịch),
--  date (thời gian giao dịch), amounts (số tiền giao dịch), descriptions (mô tả giao dịch).
create table Transactions (
    tran_number int not null unique,
    account_number int not null,
    `date` date not null,
    amount double not null,
    descriptions varchar(255) not null,
    foreign key (account_number) references `Accounts`(account_number)
);
select*from Customer;
select*from Accounts;
select*from Transactions;