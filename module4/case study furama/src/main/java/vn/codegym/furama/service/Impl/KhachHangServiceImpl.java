package vn.codegym.furama.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.KhachHang;
import vn.codegym.furama.repository.KhachHangReponsitory;
import vn.codegym.furama.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangReponsitory khachHangReponsitory;

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return this.khachHangReponsitory.findAll(pageable);
    }

    @Override
    public Page<KhachHang> findAllByHoTenContaining(String name, Pageable pageable) {
        return this.khachHangReponsitory.findAllByHoTenContaining(name,pageable);
    }

    @Override
    public KhachHang findById(Long id) {
        return this.khachHangReponsitory.findById(id).orElse(null);
    }

    @Override
    public void save(KhachHang khachHang) {
        this.khachHangReponsitory.save(khachHang);
    }

    @Override
    public void remove(Long id) {
        this.khachHangReponsitory.deleteById(id);
    }

}
