package vn.codegym.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama.model.HopDong;

import java.util.List;

public interface HopDongService {
    Page<HopDong> findAllByDelete1(Pageable pageable, Integer integer);

    Page<HopDong> findAllByKhachHang_HoTenContainingAndAndDelete1(String Khachhang, Pageable pageable, Integer integer);

    List<HopDong> findAll();

    HopDong findById(Long id);

    void save(HopDong hopDong);

    void remove(Long id);
}
