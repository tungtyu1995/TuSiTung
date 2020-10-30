drop database if exists exam;
create database exam;
use exam;

create table product(
	id int primary key ,
	`name` varchar(50) not null,
    price varchar(50),
	quantity varchar(50),
	color varchar(50),
	descriptions varchar(50),
	category varchar(50)
);

INSERT INTO `exam`.`product` (`id`, `name`, `quantity`, `color`, `descriptions`, `category`) 
VALUES ('1', 'abc', '123', '1234', '12345', '123456');

INSERT INTO `exam`.`product` (`id`, `name`, `quantity`, `color`, `descriptions`, `category`) 
VALUES ('2', 'abcd', '123', '1234', '12345', '123456');

