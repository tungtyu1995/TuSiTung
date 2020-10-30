drop database if exists library_database;
create database library_database;
use library_database;

-- thể loại
create table category(
	category_number varchar(25) primary key,
	category varchar(50) not null
);

-- sách
create table book(
	book_number varchar(50) primary key,
	name_book varchar(50) not null,
	prince_book double not null,
	author_book varchar(50) not null,
	category_number varchar(50) not null,
	publishing_year varchar(50) not null,
	publisher_code varchar(50) not null,
	FOREIGN	KEY	(category_number) REFERENCES category(category_number)
);

-- siên viên
create table student(
	student_number varchar(50) primary key,
	student_name varchar(50) not null,
	address_line1 varchar(50) not null,
	address_line2 varchar(50),
	email varchar(50) not null,
	image varchar(50) not null
);

-- thẻ thư viện
create table library_card(
	library_card_number varchar(50) primary key,
    `name` varchar(50) not null,
    image varchar(50) not null,
	start_day date not null,
	expiration_date date not null,
    note varchar(50),
	student_number varchar(50),
	FOREIGN	KEY	(student_number) REFERENCES student(student_number)
);

-- nhân viênbook
create table employee(
	employee_number varchar(50) primary key,
	employee_name varchar(50) not null,
	employee_date_of_birth varchar(50) not null,
	employee_number_phone varchar(50) not null
);

-- mượn sách
create table borrow_books(
	`code` varchar(50) primary key,
	library_card_number varchar(50) not null unique,
    book_number varchar(50) not null unique,
	employee_number varchar(50) not null,
	day_borrow_books date not null,
    day_return date,
    FOREIGN	KEY	(employee_number) REFERENCES employee(employee_number),
	FOREIGN	KEY	(library_card_number) REFERENCES library_card(library_card_number),
    FOREIGN	KEY	(book_number) REFERENCES book(book_number)
);


INSERT INTO `library_database`.`category` (`category_number`, `category`) VALUES 
('th', 'toán học'),
('vh', 'văn học'),
('sh', 'sinh học'),
('tb', 'tầm bậy'),
('hh', 'hóa học');

INSERT INTO `library_database`.`book` (`book_number`, `name_book`, `prince_book`, `author_book`, `category_number`, `publishing_year`, `publisher_code`) VALUES 
('t-l1', 'toán lớp 1', '25000', 'tst', 'th', '1995', 'NXB-GG'),
('v_l1', 'văn lớp 1', '23000', 'tst', 'vh', '1993', 'NXB-GG'),
('tb-cc', 'tầm bậy cao cấp', '50000', 'tst', 'tb', '2010', 'NXB-TB'),
('sh-l3', 'sinh học lớp 3', '22000', 'tst', 'sh', '1994', 'NXB-GG'),
('hh-l8', 'hóa học lớp 8', '34000', 'tst', 'hh', '1992', 'NXB-GG');

INSERT INTO `library_database`.`student` (`student_number`, `student_name`, `address_line1`, `email`, `image`) VALUES 
('cc-01', 'Khá Bảnh', 'đà nẵng', 'khabang@gail.com', 'abc'),
 ('cc-02', 'huấn hoa hồng', 'đà nẵng', 'huan@gmail.com', 'xyz'),
 ('cc-03', 'thị nở', 'đà nẵng', 'nơ@gmail.com', 'kml'),
 ('cc-04', 'chí phèo', 'đà nẵng', 'pheo@gmail.com', 'uml'),
 ('cc-05', 'nguyễn thị dậu', 'đà nẵng', 'dau@gmaiil.com', 'ddd');

INSERT INTO `library_database`.`library_card` (`library_card_number`, `name`, `image`, `start_day`, `expiration_date`, `note`, `student_number`) VALUES 
('123', 'Khá Bảnh', 'abc', '2012/12/12', '2015/12/12', '...', 'cc-01'),
('121', 'huấn hoa hồng', 'xyz', '2012/12/12', '2015/12/12', '...', 'cc-02'),
('120', 'thị nở', 'kml', '2012/12/12', '2015/12/12', '...', 'cc-03'),
('124', 'chí phèo', 'uml', '2012/12/12', '2015/12/12', '...', 'cc-04'),
('125', 'nguyễn thị dậu', 'ddd', '2012/12/12', '2015/12/12', '...', 'cc-05');

INSERT INTO `library_database`.`employee` (`employee_number`, `employee_name`, `employee_date_of_birth`, `employee_number_phone`) VALUES 
('a', 'abc', '1995/12/12', '0123456778'),
('b', 'bac', '1995/12/12', '0123456788'),
('c', 'cba', '1995/12/12', '0123456777');

-- INSERT INTO `library_database`.`borrow_books` (`code`, `library_card_number`, `book_number`, `employee_number`, `day_borrow_books`, `day_return`) VALUES 
-- ('01', '123', 't-l1', 'a', '2020/05/12', '2020/05/27'),
-- ('02', '121', 'v-l1', 'b', '2020/05/11','2020/05/12'),
-- ('03', '124', 'tb-cc', 'c', '2020/05/09', '2020/05/12');

select*from category;
select*from book;
select*from student;
select*from library_card;
select*from employee;
select*from borrow_books
where day_return is null;
