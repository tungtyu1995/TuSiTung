drop database if exists demo_database;
create database demo_database;
use demo_database;

create table products(
	id int,
	product_code int ,
	product_name varchar(50) ,
	product_price double ,
	product_amount double ,
	product_description varchar(50) ,
	product_status varchar(50) 
);

insert into products values
(1,123,'bánh',10,10,'bánh mì', 'còn'),
(1,124,'bánh',9,9,'bánh rán', 'còn'),
(2,456,'kẹo',8,8,'kẹo mút','còn'),
(2,457,'kẹo',7,7,'kẹo hứt', 'hết');

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)

create unique index uidx_product_code on products(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)

create index index_name_price on products(product_name,product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào

explain select *
from products
where product_code = 124;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.

create view product_view
as
select product_code, product_name, product_price, product_status
from products;

select*
from product_view;

-- Tiến hành sửa đổi view
alter view product_view
as
select product_code, product_name
from products;

select*
from product_view;

-- Tiến hành xoá view
drop view product_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter $$
create procedure find_by_product()
begin
select *
from products;
end; $$
delimiter ;

call  find_by_product();

-- Tạo store procedure thêm một sản phẩm mới
delimiter $$
create procedure insert_product(
	id int,
	product_code int ,
	product_name varchar(50) ,
	product_price double ,
	product_amount double ,
	product_description varchar(50) ,
	product_status varchar(50)
)
begin 
    insert into products values(id, product_code, product_name, product_price, product_amount, product_description, product_status);
end;$$
delimiter ;

call insert_product(1,123,'bánh',10,10,'bánh mì', 'còn');

select *
from products;

-- Tạo store procedure sửa thông tin sản phẩm theo id

delimiter $$
create procedure update_products(
    u_id int,
	u_product_code int ,
	u_product_name varchar(50) ,
	u_product_price double ,
	u_product_amount double ,
	u_product_description varchar(50) ,
	u_product_status varchar(50)
)
begin
     update products 
     set
	id = u_id ,
	product_code = u_product_code ,
	product_name = u_product_name  ,
	product_price = u_product_price ,
	u_product_amount = u_product_amount ,
	product_description = u_product_description ,
	product_status = u_product_status 
    where product_name = u_product_name;
    end; $$
    delimiter ;
    
    call update_products(2,456,'kẹo',8,8,'kẹo mút','còn');
    call update_products(1,124,'bánh',9,9,'bánh rán', 'còn');
    
-- Tạo store procedure xoá sản phẩm theo id
   delimiter $$
   create procedure delete_products(d_id int)
   begin
         delete from products where id = d_id;
         end; $$
         delimiter ;
         
   call delete_products(2);
   call delete_products(1);