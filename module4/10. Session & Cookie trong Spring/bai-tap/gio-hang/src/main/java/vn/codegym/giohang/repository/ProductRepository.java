package vn.codegym.giohang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.giohang.model.Product;

public interface ProductRepository  extends JpaRepository<Product,Long> {
}
