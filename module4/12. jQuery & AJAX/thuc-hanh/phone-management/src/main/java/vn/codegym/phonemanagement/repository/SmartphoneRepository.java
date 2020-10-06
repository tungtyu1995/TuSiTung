package vn.codegym.phonemanagement.repository;

import org.springframework.data.repository.CrudRepository;
import vn.codegym.phonemanagement.model.Smartphone;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Integer> {
}
