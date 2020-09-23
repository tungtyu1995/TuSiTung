package dao;

import model.MatBang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangDAO implements IMatBangDAO {
    private static final String INSERT_USERS_SQL = "INSERT INTO mat_bang" + "  ( id,  dienTich,  trangThai,  tang,  loaiVanPhong,  gia,  ngayBatDau,  ngayKetThuc ) VALUES " +
            " (?, ? , ? , ? , ? , ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select * from mat_bang where id =?";
    private static final String SELECT_ALL_USERS = "select * from mat_bang order by id";
    private static final String DELETE_USERS_SQL = "delete from mat_bang where id = ?;";

    private BaseDAO baseDAO = new BaseDAO();

    public MatBangDAO() {
    }

    //     id,  dienTich,  trangThai,  tang,  loaiVanPhong,  gia,  ngayBatDau,  ngayKetThuc
    @Override
    public void insertObj(MatBang obj) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try {
            Connection connection = baseDAO.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL);
//            id,  dienTich,  trangThai,  tang,  loaiVanPhong,  gia,  ngayBatDau,  ngayKetThuc
            statement.setString(1, obj.getId());
            statement.setString(2, obj.getDienTich());
            statement.setString(3, obj.getTrangThai());
            statement.setString(4, obj.getTang());
            statement.setString(5, obj.getLoaiVanPhong());
            statement.setString(6, obj.getGia());
            statement.setString(7, obj.getNgayBatDau());
            statement.setString(8, obj.getNgayKetThuc());
            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MatBang selectObj(String id) {
        MatBang obj = null;
        // Step 1: Establishing a Connection
        try {
            Connection connection = baseDAO.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                id,  dienTich,  trangThai,  tang,  loaiVanPhong,  gia,  ngayBatDau,  ngayKetThuc
                String dienTich = rs.getString("dienTich");
                String trangThai = rs.getString("trangThai");
                String tang = rs.getString("tang");
                String loaiVanPhong = rs.getString("loaiVanPhong");
                String gia = rs.getString("gia");
                String ngayBatDau = rs.getString("ngayBatDau");
                String ngayKetThuc = rs.getString("ngayKetThuc");

                obj = new MatBang(id, dienTich, trangThai, tang, loaiVanPhong, gia, ngayBatDau, ngayKetThuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public List<MatBang> selectAllObjs() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<MatBang> objs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try {
            Connection connection = baseDAO.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
//            id,  dienTich,  trangThai,  tang,  loaiVanPhong,  gia,  ngayBatDau,  ngayKetThuc
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String id = rs.getString("id");
                String dienTich = rs.getString("dienTich");
                String trangThai = rs.getString("trangThai");
                String tang = rs.getString("tang");
                String loaiVanPhong = rs.getString("loaiVanPhong");
                String gia = rs.getString("gia");
                String ngayBatDau = rs.getString("ngayBatDau");
                String ngayKetThuc = rs.getString("ngayKetThuc");
                objs.add(new MatBang(id, dienTich, trangThai, tang, loaiVanPhong, gia, ngayBatDau, ngayKetThuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objs;
    }

    @Override
    public void deleteObj(String id) throws SQLException {

        try {
            Connection connection = baseDAO.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//    @Override
//    public void updateObj(MatBang obj) throws SQLException {
//
//        try {
//            Connection connection = baseDAO.getConnection();
//            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
////            id, phoneNumber, group,  name,  gender,  address,  birthday,  email
//
//            statement.setString(1, obj.getPhoneNumber());
//            statement.setString(2, obj.getGroup());
//            statement.setString(3, obj.getName());
//            statement.setString(4, obj.getGender());
//            statement.setString(5, obj.getAddress());
//            statement.setString(6, obj.getBirthday());
//            statement.setString(7, obj.getEmail());
//            statement.setInt(8, obj.getId());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
