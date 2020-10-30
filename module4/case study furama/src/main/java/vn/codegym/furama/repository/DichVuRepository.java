package vn.codegym.furama.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama.model.DichVu;

public interface DichVuRepository extends JpaRepository<DichVu, Long> {
    Page<DichVu> findAll(Pageable pageable);

    Page<DichVu> findAllByTenDichVuContaining(String name, Pageable pageable);
}
