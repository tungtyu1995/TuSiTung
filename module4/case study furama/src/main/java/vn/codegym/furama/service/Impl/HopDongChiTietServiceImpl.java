package vn.codegym.furama.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.HopDong;
import vn.codegym.furama.model.HopDongChiTiet;
import vn.codegym.furama.repository.HopDongChiTietRepository;
import vn.codegym.furama.service.HopDongChiTietService;

@Service
public class HopDongChiTietServiceImpl implements HopDongChiTietService {

    @Autowired
    HopDongChiTietRepository hopDongChiTietRepository;


    @Override
    public Page<HopDongChiTiet> findAll(Pageable pageable) {
        return this.hopDongChiTietRepository.findAll(pageable);
    }

    @Override
    public Page<HopDong> findAllByHopDong_Id(Integer id, Pageable pageable) {
        return this.hopDongChiTietRepository.findAllByHopDong_Id(id, pageable);
    }

    @Override
    public HopDongChiTiet findById(Long id) {
        return this.hopDongChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public void save(HopDongChiTiet hopDongChiTiet) {
        this.hopDongChiTietRepository.save(hopDongChiTiet);
    }

    @Override
    public void remove(Long id) {
        this.hopDongChiTietRepository.deleteById(id);
    }
}