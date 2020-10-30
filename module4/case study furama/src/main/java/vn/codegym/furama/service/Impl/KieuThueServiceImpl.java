package vn.codegym.furama.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.KieuThue;
import vn.codegym.furama.repository.KieuThueRepository;
import vn.codegym.furama.service.KieuThueService;

import java.util.List;

@Service
public class KieuThueServiceImpl implements KieuThueService {
    @Autowired
    private KieuThueRepository kieuThueRepository;

    @Override
    public List<KieuThue> findAll() {
        return this.kieuThueRepository.findAll();
    }
}
