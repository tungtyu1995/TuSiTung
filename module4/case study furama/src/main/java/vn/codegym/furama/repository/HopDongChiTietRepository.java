package vn.codegym.furama.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.HopDong;
import vn.codegym.furama.model.HopDongChiTiet;

public interface HopDongChiTietRepository extends JpaRepository<HopDongChiTiet, Long> {
    Page<HopDongChiTiet> findAll(Pageable pageable);

    Page<HopDong> findAllByHopDong_Id(Integer id, Pageable pageable);
}
