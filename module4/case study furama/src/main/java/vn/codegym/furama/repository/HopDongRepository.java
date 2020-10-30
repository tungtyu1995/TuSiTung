package vn.codegym.furama.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.HopDong;

import java.util.List;

public interface HopDongRepository extends JpaRepository<HopDong, Long> {
    Page<HopDong> findAllByDelete1(Pageable pageable, Integer integer);

    List<HopDong> findAll();

    Page<HopDong> findAllByKhachHang_HoTenContainingAndAndDelete1(String Khachhang, Pageable pageable, Integer integer);
}
