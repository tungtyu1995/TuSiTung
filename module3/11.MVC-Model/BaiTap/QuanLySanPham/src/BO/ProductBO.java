package BO;

import model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    List<Product> finByName(String productName);

    void update(int id, Product product);

    void remove(int id);
}
