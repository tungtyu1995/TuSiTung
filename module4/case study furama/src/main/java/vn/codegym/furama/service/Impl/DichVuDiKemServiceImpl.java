package vn.codegym.furama.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.DichVuDiKem;
import vn.codegym.furama.repository.DichVuDiKemRepository;
import vn.codegym.furama.service.DichVuDiKemService;

import java.util.List;

@Service
public class DichVuDiKemServiceImpl implements DichVuDiKemService {

    @Autowired
    private DichVuDiKemRepository dichVuDiKemRepository;

    @Override
    public List<DichVuDiKem> findAll() {
        return this.dichVuDiKemRepository.findAll();
    }
}
