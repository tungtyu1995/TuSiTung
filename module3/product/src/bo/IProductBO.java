package bo;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductBO {
    public void insertProduct(Product product) throws SQLException;

    public Product selectProduct(int id);

    public List<Product> selectAllProducts();

    public void deleteProduct(int id) throws SQLException;

    public void updateProduct(Product product) throws SQLException;
}
