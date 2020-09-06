package dao;

import model.Product;

import java.util.List;

public interface IProductDao {

    public List<Product> selectAllProduct();

    public void updateProduct(Product product);

    public void deleteProduct(int id);

    public void insertProduct(Product product);

    public Product selecProduct(int id);

    public List<Product> findProductByName(String name);
}
