package vn.codegym.furama.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.LoaiDichVu;
import vn.codegym.furama.repository.LoaiDichVuRepository;
import vn.codegym.furama.service.LoaiDichVuService;

import java.util.List;

@Service
public class LoaiDichVuServiceImpl implements LoaiDichVuService {

    @Autowired
    private LoaiDichVuRepository loaiDichVuRepository;

    @Override
    public List<LoaiDichVu> findAll() {
        return this.loaiDichVuRepository.findAll();
    }
}
