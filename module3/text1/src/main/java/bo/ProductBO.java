package bo;

import dao.IProductDAO;
import dao.ProductDAO;
import model.Product;

import java.util.List;

public class ProductBO implements IProductBO {
   private IProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> selectAllProduct() {
        return this.productDAO.selectAllProduct();
    }

    @Override
    public void updateProduct(Product product) {
        this.productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        this.productDAO.deleteProduct(id);
    }

    @Override
    public void insertProduct(Product product) {
        this.productDAO.insertProduct(product);
    }

    @Override
    public Product selectProduct(int id) {
        return this.productDAO.selectProduct(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return this.productDAO.findProductByName(name);
    }
}
