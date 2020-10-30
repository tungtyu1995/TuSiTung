package vn.codegym.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama.model.KhachHang;

public interface KhachHangService {
    Page<KhachHang> findAll(Pageable pageable);

    Page<KhachHang> findAllByHoTenContaining(String name, Pageable pageable);

    KhachHang findById(Long id);

    void save(KhachHang khachHang);

    void remove(Long id);
}
