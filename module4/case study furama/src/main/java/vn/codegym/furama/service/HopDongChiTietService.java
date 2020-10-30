package vn.codegym.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama.model.HopDong;
import vn.codegym.furama.model.HopDongChiTiet;

public interface HopDongChiTietService {
    Page<HopDongChiTiet> findAll(Pageable pageable);

    Page<HopDong> findAllByHopDong_Id(Integer id, Pageable pageable);

    HopDongChiTiet findById(Long id);

    void save(HopDongChiTiet hopDongChiTiet);

    void remove(Long id);
}
