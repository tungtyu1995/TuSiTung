package bo;

import model.Product;

import java.util.List;

public interface IProductBO {
    public List<Product> selectAllProduct();

    public void updateProduct(Product product);

    public void deleteProduct(int id);

    public void insertProduct(Product product);

    public Product selectProduct(int id);

    public List<Product> findProductByName(String name);
}
