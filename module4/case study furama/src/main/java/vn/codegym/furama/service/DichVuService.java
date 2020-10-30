package vn.codegym.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furama.model.DichVu;

public interface DichVuService {
    Page<DichVu> findAll(Pageable pageable);

    Page<DichVu> findAllByTenDichVuContaining(String name, Pageable pageable);

    DichVu findById(Long id);

    void save(DichVu dichVu);

    void remove(Long id, RedirectAttributes redirectAttributes);
}
