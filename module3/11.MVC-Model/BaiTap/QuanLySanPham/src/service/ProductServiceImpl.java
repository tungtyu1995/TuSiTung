package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", "20000000", "Red", "Apple"));
        products.put(2, new Product(2, "Iac Book", "30000000", "Red", "Apple"));
        products.put(3, new Product(3, "Apple Watch", "10000000", "Red", "Apple"));
        products.put(4, new Product(4, "Apple AirPods", "5000000", "Red", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
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

    public List<Product> finByName(String productName) {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            try {
                product = entry.getValue();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            if (product.getProductName().contains(productName)) {
                productList.add(product);
            }
        }
        return productList;
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
