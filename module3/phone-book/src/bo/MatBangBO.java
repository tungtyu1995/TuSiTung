package bo;

import dao.IMatBangDAO;
import dao.MatBangDAO;
import model.MatBang;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangBO implements IMatBangBO {
    private IMatBangDAO iMatBangDAO = new MatBangDAO();

    public List<MatBang> timKiemTheoLoaiVP(String loaiVanPhong){
        List<MatBang> objs = new ArrayList<>();
        try {
            for (MatBang obj: iMatBangDAO.selectAllObjs()) {
                if(obj.getLoaiVanPhong().equals(loaiVanPhong))
                    objs.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return objs;
    }

    public List<MatBang> timKiemTheoGia(String gia){
        List<MatBang> objs = new ArrayList<>();
        try {
            for (MatBang obj: iMatBangDAO.selectAllObjs()) {
                if(obj.getGia().equals(gia))
                    objs.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return objs;
    }

    public List<MatBang> timKiemTheoTang(String tang){
        List<MatBang> objs = new ArrayList<>();
        try {
            for (MatBang obj: iMatBangDAO.selectAllObjs()) {
                if(obj.getTang().contains(tang))
                    objs.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return objs;
    }



    @Override
    public void insertObj(MatBang obj) throws SQLException {
        this.iMatBangDAO.insertObj(obj);
    }

    @Override
    public MatBang selectObj(String id) {
        return this.iMatBangDAO.selectObj(id);
    }

    @Override
    public List<MatBang> selectAllObjs() {
        return this.iMatBangDAO.selectAllObjs();
    }

    @Override
    public void deleteObj(String id) throws SQLException {
        this.iMatBangDAO.deleteObj(id);
    }
}
