package bo;

import model.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface IMatBangBO {
    public void insertObj(MatBang obj) throws SQLException;

    public MatBang selectObj(String id);

    public List<MatBang> selectAllObjs();

    public void deleteObj(String  id) throws SQLException;

}
