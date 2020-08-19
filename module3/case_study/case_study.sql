drop database if exists casa_study_database;
create database casa_study_database;
use casa_study_database;

create table vi_tri(
	id_vi_tri int primary key,
	ten_vi_tri varchar(50) not null
);

create table trinh_do(
	id_trinh_do int primary key,
	trinh_do varchar(50) not null
);

create table bo_phan(
	id_bo_phan int primary key,
	ten_bo_phan varchar(50) not null
);

create table nhan_vien(
	id_nhan_vien int primary key,
	ho_ten_nhan_vien varchar(50) not null,
	id_vi_tri int not null,
	id_trinh_do int not null,
	id_bo_phan int not null,
	ngay_sinh date  not null,
	so_cmnd varchar(50) not null unique,
	luong int not null,
	sdt varchar(50) not null unique,
	email varchar(50) not null unique,
	dia_chi varchar(50) not null,
	FOREIGN	KEY	(id_vi_tri) REFERENCES vi_tri(id_vi_tri),
	FOREIGN	KEY	(id_trinh_do) REFERENCES trinh_do(id_trinh_do),
	FOREIGN	KEY	(id_bo_phan) REFERENCES bo_phan(id_bo_phan)

);

create table loai_khach_hang(
	id_loai_khach_hang int primary key,
	loai_khch_hang varchar(50) not null
);

create table khach_hang(
	id_khach_hang int primary key,
	id_loai_khach_hang int not null,
	ho_ten varchar(50) not  null,
	ngay_sinh date not null,
	so_cmnd varchar(50) not null unique,
	sdt varchar(50) not null unique,
	email varchar(50) not null unique,
	dia_chi varchar(50) not null,
	FOREIGN	KEY	(id_loai_khach_hang) REFERENCES loai_khach_hang(id_loai_khach_hang)
);

create table kieu_thue(
	id_kieu_thue int primary key,
	ten_kieu_thue varchar(50) not null,
	gia int not null
);
create table loai_dich_vu(
	id_loai_dich_vu int primary key,
	ten_loai_dich_vu varchar(50) not null
);

create table dich_vu(
	id_dich_vu int primary key,
	ten_dich_vu varchar(50) not null,
	dien_tich int not null,
	so_tang int not null,
	so_nguoi_toi_da varchar(50) not null,
	chi_phi_thue varchar(50) not null,
	id_kieu_thue int not null,
	id_loai_dich_vu int not null,
	trang_thai varchar(50) not null,
	FOREIGN	KEY	(id_kieu_thue) REFERENCES kieu_thue(id_kieu_thue),
	FOREIGN	KEY	(id_loai_dich_vu) REFERENCES loai_dich_vu(id_loai_dich_vu)
);

create table hop_dong(
	id_hop_dong int primary key,
	id_nhan_vien int not null,
	id_khach_hang int not null,
	id_dich_vu int not null,
	ngay_lam_hop_dong date not null,
	ngay_ket_thuc date not null,
	tien_dat_coc int not null,
	tong_tien int not null,
	FOREIGN	KEY	(id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien),
	FOREIGN	KEY	(id_khach_hang) REFERENCES khach_hang(id_khach_hang),
	FOREIGN	KEY	(id_dich_vu) REFERENCES dich_vu(id_dich_vu)
);

create table dich_vu_di_kem(
	id_dich_vu_di_kem int primary key,
	ten_dich_vu_di_kem varchar(50) not null,
	gia int not null,
	don_vi int not null,
	trang_thai_kha_dung  varchar(50) not null
);
create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int primary key,
	id_hop_dong int not null,
	id_dich_vu_di_kem int not null,
	so_luong int not null,
	FOREIGN	KEY	(id_hop_dong) REFERENCES hop_dong(id_hop_dong),
	FOREIGN	KEY	(id_dich_vu_di_kem) REFERENCES dich_vu_di_kem(id_dich_vu_di_kem)
);

-- 2. hiển thị nhân viên bắt đầu bằng h,t,k tối đa 15 ký tự
select*from nhan_vien
where ho_ten_nhan_vien LIKE 'h%' or 't%' or 'k%' 
and 
LENGTH(ho_ten_nhan_vien) >= 15;

-- 3.Hiển thị thông tin của tất cả khách hàng 
-- có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select*from khach_hang
where DATEDIFF(CURDATE(), khach_hang.ngay_sinh) / 365 between 15 and 50 
and 
dia_chi = 'đà nẵng' or 'quảng trị';


select*from vi_tri;
select*from bo_phan;
select*from bo_phan;
select*from nhan_vien;
select*from loai_khach_hang;
select*from khach_hang;
select*from kieu_thue;
select*from loai_dich_vu;
select*from dich_vu;
select*from hop_dong;
select*from dich_vu_di_kem;
select*from hop_dong_chi_tiet;