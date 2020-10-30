package bo;

import dao.IProductDAO;
import dao.ProductDAO;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBO implements IProductBO {
    private IProductDAO productDAO = new ProductDAO();

    public List<Product> findProductByCountry(String name){
        List<Product> products = new ArrayList<>();
        try {
            for (Product product: productDAO.selectAllProducts()) {
                if(product.getName().toLowerCase().contains(name))
                    products.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return products;
    }
    @Override
    public void insertProduct(Product product) throws SQLException {
        this.productDAO.insertProduct(product);
    }

    @Override
    public Product selectProduct(int id) {
        return this.productDAO.selectProduct(id);
    }

    @Override
    public List<Product> selectAllProducts() {
        return this.productDAO.selectAllProducts();
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
         this.productDAO.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
         this.productDAO.updateProduct(product);
    }
}
