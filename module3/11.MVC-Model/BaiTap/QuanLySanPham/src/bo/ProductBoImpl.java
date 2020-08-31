package bo;

import dao.ProductService;
import dao.ProductServiceImpl;
import model.Product;

import java.util.List;

public class ProductBoImpl implements ProductBO {
    private ProductService productService = new ProductServiceImpl();

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public void save(Product product) {
        productService.save(product);
    }

    @Override
    public Product findById(int id) {
        return productService.findById(id);
    }

    @Override
    public List<Product> finByName(String productName) {
        return productService.finByName(productName);
    }

    @Override
    public void update(int id, Product product) {
        productService.update(id, product);
    }

    @Override
    public void remove(int id) {
        productService.remove(id);
    }
}
