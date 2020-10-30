package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_PRODUCT_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_PRODUCT = "select * from users order by `name`";
    private static final String DELETE_PRODUCT_SQL = "delete from users where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SELECT_PRODUCT_BY_NAME = "select * from product where name like ?";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                String quantity = rs.getString(4);
                String color = rs.getString(5);
                String descriptions = rs.getString(6);
                String category = rs.getString(7);
                productList.add(new Product(id, name, price, quantity, color, descriptions, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public void insertProduct(Product product) {

    }

    @Override
    public Product selecProduct(int id) {
        return null;
    }

    @Override
    public List<Product> findProductByName(String name) {
        return null;
    }
}
