package vn.codegym.furama.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.KhachHang;


public interface KhachHangReponsitory extends JpaRepository<KhachHang, Long> {
    Page<KhachHang> findAll(Pageable pageable);

    Page<KhachHang> findAllByHoTenContaining(String name, Pageable pageable);
}