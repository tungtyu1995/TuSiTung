package vn.codegym.furama.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.LoaiKhachHang;
import vn.codegym.furama.repository.LoaiKhachHangRepository;
import vn.codegym.furama.service.LoaiKhachHangService;

import java.util.List;

@Service
public class LoaiKhachHangServiceImpl implements LoaiKhachHangService {


    @Autowired
    private LoaiKhachHangRepository loaiKhachHangRepository;

    @Override
    public List<LoaiKhachHang> findAll() {
        return this.loaiKhachHangRepository.findAll();
    }
}

