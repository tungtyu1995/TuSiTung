package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iphone", "500", "12", "blue", "ok", "phone"));
        products.put(2, new Product(2, "galaxy", "100", "100", "red", "no", "phone"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList(products.values());
    }

    @Override
    public void save(Product product) {

        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
