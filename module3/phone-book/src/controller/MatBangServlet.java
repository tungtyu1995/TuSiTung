package controller;

import bo.MatBangBO;
import model.MatBang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PhoneBookServlet", urlPatterns = "/matBang")
public class MatBangServlet extends HttpServlet {

    private MatBangBO matBangBO = new MatBangBO();

    String list = "matBang/list.jsp";
    String delete = "matBang/delete.jsp";
    String create = "matBang/create.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertObj(request, response);
                    break;
                case "timKiemTheoLoaiVP":
                    timKiemTheoLoaiVP(request, response);
                    break;
                case "timKiemTheoGia":
                    timKiemTheoGia(request, response);
                    break;
                case "timKiemTheoTang":
                    timKiemTheoTang(request, response);
                    break;
                case "delete":
                    deleteObj(request, response);
                    break;
                default:
                    listObj(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                default:
                    listObj(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void timKiemTheoLoaiVP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loaiVanPhong = request.getParameter("loaiVanPhong");
        List<MatBang> listObj = this.matBangBO.timKiemTheoLoaiVP(loaiVanPhong);
        request.setAttribute("listObj", listObj);
        RequestDispatcher dispatcher = request.getRequestDispatcher(list);
        dispatcher.forward(request, response);
    }

    private void timKiemTheoGia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gia = request.getParameter("gia");
        List<MatBang> listObj = this.matBangBO.timKiemTheoGia(gia);
        request.setAttribute("listObj", listObj);
        RequestDispatcher dispatcher = request.getRequestDispatcher(list);
        dispatcher.forward(request, response);
    }

    private void timKiemTheoTang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tang = request.getParameter("tang");
        List<MatBang> listObj = this.matBangBO.timKiemTheoTang(tang);
        request.setAttribute("listObj", listObj);
        RequestDispatcher dispatcher = request.getRequestDispatcher(list);
        dispatcher.forward(request, response);
    }

    private void listObj(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<MatBang> listObj = matBangBO.selectAllObjs();
        request.setAttribute("listObj", listObj);
        RequestDispatcher dispatcher = request.getRequestDispatcher(list);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(create);
        dispatcher.forward(request, response);
    }

    private void insertObj(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        id,  dienTich,  trangThai,  tang,  loaiVanPhong,  gia,  ngayBatDau,  ngayKetThuc
        String id = request.getParameter("id");
        String dienTich = request.getParameter("dienTich");
        String trangThai = request.getParameter("trangThai");
        String tang = request.getParameter("tang");
        String loaiVanPhong = request.getParameter("loaiVanPhong");
        String gia = request.getParameter("gia");
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");

        MatBang newObj = new MatBang(id, dienTich, trangThai, tang, loaiVanPhong, gia, ngayBatDau, ngayKetThuc);
        matBangBO.insertObj(newObj);
        List<MatBang> listObj = matBangBO.selectAllObjs();
        request.setAttribute("listObj", listObj);
        RequestDispatcher dispatcher = request.getRequestDispatcher(list);
        dispatcher.forward(request, response);
    }


    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        MatBang obj = matBangBO.selectObj(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher(delete);
        request.setAttribute("obj", obj);
        dispatcher.forward(request, response);

    }

    private void deleteObj(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        this.matBangBO.deleteObj(id);
        try {
            response.sendRedirect("/matBang");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}