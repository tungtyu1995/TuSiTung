package dao;

import model.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface IMatBangDAO {
    public void insertObj(MatBang obj) throws SQLException;

    public MatBang selectObj(String id);

    public List<MatBang> selectAllObjs();

    public void deleteObj(String id) throws SQLException;

//    public void updateObj(MatBang obj) throws SQLException;
}
