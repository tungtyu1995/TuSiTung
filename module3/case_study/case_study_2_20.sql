-- 2. hiển thị nhân viên bắt đầu bằng h,t,k tối đa 15 ký tự
select*from nhan_vien
where ho_ten_nhan_vien LIKE ('k%') or ho_ten_nhan_vien LIKE ('h%') or ho_ten_nhan_vien LIKE ('t%') 
and  LENGTH(ho_ten_nhan_vien) <= 15;

-- 3.Hiển thị thông tin của tất cả khách hàng 
-- có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select*from khach_hang
where DATEDIFF(CURDATE(), khach_hang.ngay_sinh) / 365 between 18 and 50 
and 
dia_chi in ('đà nẵng','quảng trị');

-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
--  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
--  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select khach_hang.ho_ten , count(hop_dong.id_hop_dong) as 'số lần đặt phòng'
from  khach_hang
right join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
where khach_hang.id_loai_khach_hang = 1
group by khach_hang.id_khach_hang;

-- 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
--  cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select khach_hang.id_khach_hang, khach_hang.ho_ten, loai_khach_hang.loai_khach_hang, hop_dong.id_hop_dong,dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, dich_vu.chi_phi_thue + (dich_vu_di_kem.don_vi*dich_vu_di_kem.gia) as 'Tổng Tiền'
from khach_hang
	left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
	left join loai_khach_hang on loai_khach_hang.id_loai_khach_hang = khach_hang.id_loai_khach_hang
	left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
	left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem;

-- 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong
from dich_vu
	inner join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
	left join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where (datediff(hop_dong.ngay_lam_hop_dong, '2019-01-01')<0) or (datediff(hop_dong.ngay_lam_hop_dong, '2019-03-31')>0);

-- 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
	left join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
	left join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where (hop_dong.ngay_lam_hop_dong between '2018-01-01' and '2018-12-31') and hop_dong.id_dich_vu not in(
select hop_dong.id_dich_vu 
from hop_dong 
where (hop_dong.ngay_lam_hop_dong between '2019-01-01' and '2019-12-31')
);


-- 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- c1
select distinct khach_hang.ho_ten
from khach_hang;
-- c2
select khach_hang.ho_ten
from khach_hang
group by khach_hang.ho_ten
having count(ho_ten)>=1;
-- c3
select khach_hang.ho_ten
from khach_hang
union
select khach_hang.ho_ten
from khach_hang;
 
-- 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(hop_dong.ngay_lam_hop_dong) as tháng, count(hop_dong.id_hop_dong) as 'số lượng', sum(hop_dong.tong_tien) as 'doanh thu'
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = '2019'
group by hop_dong.id_khach_hang;

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
--  Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).

select hop_dong.id_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as 'SoLuongDichVuDiKem'
from hop_dong
	join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
group by hop_dong.id_hop_dong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select dich_vu_di_kem.id_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia, dich_vu_di_kem.don_vi, dich_vu_di_kem.trang_thai_kha_dung, khach_hang.ho_ten
from dich_vu_di_kem
	join hop_dong_chi_tiet on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
	join hop_dong on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
	join loai_khach_hang on loai_khach_hang.id_loai_khach_hang = khach_hang.id_loai_khach_hang
where loai_khach_hang.loai_khach_hang  = 'Diamond' and (khach_hang.dia_chi = 'vinh' or khach_hang.dia_chi = 'quảng ngãi') 
group by khach_hang.ho_ten;

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select hop_dong.id_hop_dong, nhan_vien.ho_ten_nhan_vien, khach_hang.ho_ten, khach_hang.sdt, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as SoLuongDichVuDikem
from hop_dong
	left join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
	left join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
	left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
	left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
where (hop_dong.ngay_lam_hop_dong between '2019-10-01' and '2019-12-31') and (hop_dong.ngay_lam_hop_dong not between '2019-01-01' and '2019-06-31')
group by hop_dong.id_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

create view max
as
select dich_vu_di_kem.ten_dich_vu_di_kem, count(dich_vu_di_kem.id_dich_vu_di_kem) as 'so_luong_lon_nhat'
from hop_dong
	left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by dich_vu_di_kem.ten_dich_vu_di_kem
having count(dich_vu_di_kem.id_dich_vu_di_kem)
order by count(dich_vu_di_kem.id_dich_vu_di_kem) desc;

select *
from max
group by ten_dich_vu_di_kem
having so_luong_lon_nhat = (select max(so_luong_lon_nhat) from max);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
--  Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select hop_dong.id_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, count(dich_vu_di_kem.ten_dich_vu_di_kem) as SoLuong
from hop_dong 
	join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
	join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
	join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by dich_vu_di_kem.ten_dich_vu_di_kem
having count(dich_vu_di_kem.ten_dich_vu_di_kem) = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm 
-- IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select nhan_vien.id_nhan_vien, nhan_vien.ho_ten_nhan_vien, bo_phan.ten_bo_phan, nhan_vien.sdt, nhan_vien.dia_chi, count(hop_dong.id_nhan_vien)
from nhan_vien
	join trinh_do on trinh_do.id_trinh_do = nhan_vien.id_trinh_do
	join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan
	join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) in (2018, 2019)
group by nhan_vien.id_nhan_vien
having count(hop_dong.id_nhan_vien) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

delete from nhan_vien
where nhan_vien.id_nhan_vien not in (
select n.id_nhan_vien
from (
	select nhan_vien.id_nhan_vien 
	from nhan_vien 
	join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
	where year(hop_dong.ngay_lam_hop_dong) in (2017, 2019)) as n
);

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
--  chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

update khach_hang
set khach_hang.id_loai_khach_hang = 1
where id_khach_hang in (
	select * from (select khach_hang.id_khach_hang from khach_hang
	join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
	where year(hop_dong.ngay_lam_hop_dong) = 2019 and hop_dong.tong_tien >= 10000000 and khach_hang.id_loai_khach_hang = 2 ) as b
    );
    
    