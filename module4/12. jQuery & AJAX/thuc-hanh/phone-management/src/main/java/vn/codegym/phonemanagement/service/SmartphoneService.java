package vn.codegym.phonemanagement.service;

import vn.codegym.phonemanagement.model.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();

    Smartphone findById(Integer id);

    Smartphone save(Smartphone phone);

    Smartphone remove(Integer id);
}
