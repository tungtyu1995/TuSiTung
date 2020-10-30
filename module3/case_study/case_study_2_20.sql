-- 2. hiển thị nhân viên bắt đầu bằng h,t,k tối đa 15 ký tự
SELECT*FROM nhan_vien
WHERE ho_ten_nhan_vien LIKE ('k%') OR ho_ten_nhan_vien LIKE ('h%') OR ho_ten_nhan_vien LIKE ('t%') 
AND  LENGTH(ho_ten_nhan_vien) <= 15;

-- 3.Hiển thị thông tin của tất cả khách hàng 
-- có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

SELECT*FROM khach_hang
WHERE DATEDIFF(CURDATE(), khach_hang.ngay_sinh) / 365 BETWEEN 18 AND 50 
AND 
dia_chi IN ('đà nẵng','quảng trị');

-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
--  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
--  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

SELECT khach_hang.ho_ten , COUNT(hop_dong.id_hop_dong) AS 'số lần đặt phòng'
FROM  khach_hang
RIGHT JOIN hop_dong ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
WHERE khach_hang.id_loai_khach_hang = 1
GROUP BY khach_hang.id_khach_hang;

-- 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
--  cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

SELECT khach_hang.id_khach_hang, khach_hang.ho_ten, loai_khach_hang.loai_khach_hang, hop_dong.id_hop_dong,dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, dich_vu.chi_phi_thue + (dich_vu_di_kem.don_vi*dich_vu_di_kem.gia) AS 'Tổng Tiền'
FROM khach_hang
	LEFT JOIN hop_dong ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
	LEFT JOIN loai_khach_hang ON loai_khach_hang.id_loai_khach_hang = khach_hang.id_loai_khach_hang
	LEFT JOIN dich_vu ON dich_vu.id_dich_vu = hop_dong.id_dich_vu
	LEFT JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	LEFT JOIN dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem;

-- 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
SELECT dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong
FROM dich_vu
	INNER JOIN loai_dich_vu ON loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
	LEFT JOIN hop_dong ON hop_dong.id_dich_vu = dich_vu.id_dich_vu
WHERE (DATEDIFF(hop_dong.ngay_lam_hop_dong, '2019-01-01')<0) OR (DATEDIFF(hop_dong.ngay_lam_hop_dong, '2019-03-31')>0);

-- 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

SELECT dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
FROM dich_vu
	LEFT JOIN loai_dich_vu ON loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
	LEFT JOIN hop_dong ON hop_dong.id_dich_vu = dich_vu.id_dich_vu
WHERE (hop_dong.ngay_lam_hop_dong BETWEEN '2018-01-01' AND '2018-12-31') AND hop_dong.id_dich_vu NOT IN(
SELECT hop_dong.id_dich_vu 
FROM hop_dong 
WHERE (hop_dong.ngay_lam_hop_dong BETWEEN '2019-01-01' AND '2019-12-31')
);


-- 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- c1
SELECT DISTINCT khach_hang.ho_ten
FROM khach_hang;
-- c2
SELECT khach_hang.ho_ten
FROM khach_hang
GROUP BY khach_hang.ho_ten
HAVING COUNT(ho_ten)>=1;
-- c3
SELECT khach_hang.ho_ten
FROM khach_hang
UNION
SELECT khach_hang.ho_ten
FROM khach_hang;
 
-- 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

SELECT MONTH(hop_dong.ngay_lam_hop_dong) AS tháng, COUNT(hop_dong.id_hop_dong) AS 'số lượng', SUM(hop_dong.tong_tien) AS 'doanh thu'
FROM hop_dong
WHERE YEAR(hop_dong.ngay_lam_hop_dong) = '2019'
GROUP BY hop_dong.id_khach_hang;

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
--  Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).

SELECT hop_dong.id_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, COUNT(hop_dong_chi_tiet.id_dich_vu_di_kem) AS 'SoLuongDichVuDiKem'
FROM hop_dong
	JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
GROUP BY hop_dong.id_hop_dong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

SELECT dich_vu_di_kem.id_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia, dich_vu_di_kem.don_vi, dich_vu_di_kem.trang_thai_kha_dung, khach_hang.ho_ten
FROM dich_vu_di_kem
	JOIN hop_dong_chi_tiet ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
	JOIN hop_dong ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	JOIN khach_hang ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
	JOIN loai_khach_hang ON loai_khach_hang.id_loai_khach_hang = khach_hang.id_loai_khach_hang
WHERE loai_khach_hang.loai_khach_hang  = 'Diamond' AND (khach_hang.dia_chi = 'vinh' OR khach_hang.dia_chi = 'quảng ngãi') 
GROUP BY khach_hang.ho_ten;

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

SELECT hop_dong.id_hop_dong, nhan_vien.ho_ten_nhan_vien, khach_hang.ho_ten, khach_hang.sdt, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, COUNT(hop_dong_chi_tiet.id_dich_vu_di_kem) AS SoLuongDichVuDikem
FROM hop_dong
	LEFT JOIN nhan_vien ON nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
	LEFT JOIN khach_hang ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
	LEFT JOIN dich_vu ON dich_vu.id_dich_vu = hop_dong.id_dich_vu
	LEFT JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
WHERE (hop_dong.ngay_lam_hop_dong BETWEEN '2019-10-01' AND '2019-12-31') AND hop_dong.id_dich_vu not in(
	select hop_dong.id_dich_vu
	from  hop_dong
	where(hop_dong.ngay_lam_hop_dong between '2019-01-01' and '2019-06-30')
)
GROUP BY hop_dong.id_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

CREATE VIEW max
AS
SELECT dich_vu_di_kem.ten_dich_vu_di_kem, COUNT(dich_vu_di_kem.id_dich_vu_di_kem) AS 'so_luong_lon_nhat'
FROM hop_dong
	LEFT JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	LEFT JOIN dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
GROUP BY dich_vu_di_kem.ten_dich_vu_di_kem
HAVING COUNT(dich_vu_di_kem.id_dich_vu_di_kem)
ORDER BY COUNT(dich_vu_di_kem.id_dich_vu_di_kem) DESC;

SELECT *
FROM max
GROUP BY ten_dich_vu_di_kem
HAVING so_luong_lon_nhat = (SELECT MAX(so_luong_lon_nhat) FROM max);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
--  Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

SELECT hop_dong.id_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, COUNT(dich_vu_di_kem.ten_dich_vu_di_kem) AS SoLuong
FROM hop_dong 
	JOIN dich_vu ON dich_vu.id_dich_vu = hop_dong.id_dich_vu
	JOIN loai_dich_vu ON loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
	JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	JOIN dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
GROUP BY dich_vu_di_kem.ten_dich_vu_di_kem
HAVING COUNT(dich_vu_di_kem.ten_dich_vu_di_kem) = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm 
-- IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

SELECT nhan_vien.id_nhan_vien, nhan_vien.ho_ten_nhan_vien, bo_phan.ten_bo_phan, nhan_vien.sdt, nhan_vien.dia_chi, COUNT(hop_dong.id_nhan_vien)
FROM nhan_vien
	JOIN trinh_do ON trinh_do.id_trinh_do = nhan_vien.id_trinh_do
	JOIN bo_phan ON bo_phan.id_bo_phan = nhan_vien.id_bo_phan
	JOIN hop_dong ON hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
WHERE YEAR(hop_dong.ngay_lam_hop_dong) IN (2018, 2019)
GROUP BY nhan_vien.id_nhan_vien
HAVING COUNT(hop_dong.id_nhan_vien) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM nhan_vien
WHERE nhan_vien.id_nhan_vien NOT IN (
	SELECT n.id_nhan_vien
	FROM (
		SELECT nhan_vien.id_nhan_vien 
		FROM nhan_vien 
			JOIN hop_dong ON hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
		WHERE YEAR(hop_dong.ngay_lam_hop_dong) IN (2017, 2019)) AS abc
);
SET FOREIGN_KEY_CHECKS = 1;

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
--  chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

UPDATE khach_hang
SET khach_hang.id_loai_khach_hang = 1
WHERE id_khach_hang IN (
	SELECT * FROM (SELECT khach_hang.id_khach_hang FROM khach_hang
		JOIN hop_dong ON hop_dong.id_khach_hang = khach_hang.id_khach_hang
	WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2019 AND hop_dong.tong_tien >= 10000000 AND khach_hang.id_loai_khach_hang = 2 ) AS abc
    );
    
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM khach_hang
WHERE id_khach_hang IN (
	SELECT id_khach_hang
	FROM ( SELECT khach_hang.id_khach_hang FROM khach_hang
		JOIN hop_dong ON hop_dong.id_khach_hang = khach_hang.id_khach_hang
	WHERE YEAR(hop_dong.ngay_lam_hop_dong) < 2016) AS abc
);
SET FOREIGN_KEY_CHECKS = 1;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

UPDATE dich_vu_di_kem
JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
SET dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
WHERE dich_vu_di_kem.gia IN (
	SELECT abc.gia
	FROM(SELECT dich_vu_di_kem.gia, dich_vu_di_kem.id_dich_vu_di_kem 
		 FROM dich_vu_di_kem
			 JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
		 GROUP BY dich_vu_di_kem.id_dich_vu_di_kem
		 HAVING SUM(hop_dong_chi_tiet.so_luong) > 10 ) AS abc
);

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

SELECT nhan_vien.id_nhan_vien AS 'id', nhan_vien.ho_ten_nhan_vien AS 'ho_ten', nhan_vien.email, nhan_vien.sdt, nhan_vien.ngay_sinh, nhan_vien.dia_chi, 'nhân viên' AS 'phan_loai'
FROM nhan_vien
UNION
SELECT khach_hang.id_khach_hang, khach_hang.ho_ten, khach_hang.email, khach_hang.sdt, khach_hang.ngay_sinh, khach_hang.dia_chi, 'khách hàng'
FROM khach_hang;


											-- Hết--