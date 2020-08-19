drop database if exists method_database;
create database method_database;
use method_database;

create table bai_tap(
tt int auto_increment primary key, 
id int not null,
ten varchar(50) not null,
tuoi int not null,
khoahoc varchar(50) not null,
sotien int not null
);

INSERT INTO `method_database`.`bai_tap` (`id`, `ten`, `tuoi`, `khoahoc`, `sotien`) VALUES 
('1', 'hoang', '21', 'cntt', '400000'),
('2', 'viet', '19', 'dtvt', '320000'),
('3', 'thanh', '18', 'ktdn', '400000'),
('4', 'nhan', '19', 'ck', '450000'),
('5', 'huong', '20', 'tcnh', '500000'),
('5', 'huong', '20', 'tcnh', '200000');

select*from bai_tap;

select*from bai_tap
where bai_tap.ten = 'huong';

select sum(sotien)
from bai_tap
where id = 5;

select distinct ten
from bai_tap;

