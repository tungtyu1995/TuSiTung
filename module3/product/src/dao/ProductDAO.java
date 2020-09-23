package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String INSERT_USERS_SQL = "INSERT INTO products" + "  ( name, price, quantity, color,descriptions, category ) VALUES " +
            " (?, ? , ? , ? , ? , ?);";
    private static final String SELECT_USER_BY_ID = "select * from products where id =?";
    private static final String SELECT_ALL_USERS = "select * from products order by `name`";
    private static final String DELETE_USERS_SQL = "delete from products where id = ?;";
    private static final String UPDATE_USERS_SQL = "update products set `name` = ?,price = ?, quantity = ?, " +
            "color = ?,descriptions = ?, category = ? where id = ?;";
    //     id,  name, price, quantity, color, descriptions, category
    private BaseDAO baseDAO = new BaseDAO();

    public ProductDAO() {
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try {
            Connection connection = baseDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
//            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescriptions());
            preparedStatement.setString(6, product.getCategory());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        // Step 1: Establishing a Connection
        try {
            Connection connection = baseDAO.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String color = rs.getString("color");
                String descriptions = rs.getString("descriptions");
                String category = rs.getString("category");

                product = new Product(id, name, price, quantity, color, descriptions, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectAllProducts() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Product> products = new ArrayList<>();
        // Step 1: Establishing a Connection
        try {
            Connection connection = baseDAO.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String color = rs.getString("color");
                String descriptions = rs.getString("descriptions");
                String category = rs.getString("category");
                products.add(new Product(id, name, price, quantity, color, descriptions, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void deleteProduct(int id) throws SQLException {

        try {
            Connection connection = baseDAO.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) throws SQLException {

        try {
            Connection connection = baseDAO.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);

            statement.setString(1, product.getName());
            statement.setString(2, product.getPrice());
            statement.setString(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescriptions());
            statement.setString(6, product.getCategory());
            statement.setInt(7, product.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
