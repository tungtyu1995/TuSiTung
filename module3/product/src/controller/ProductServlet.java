package controller;

import bo.IProductBO;
import bo.ProductBO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private ProductBO productBO = new ProductBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
                    break;
                case "edit":
                    updateProduct(request, response);
                    break;
                case "find":
                    findProductName(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
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
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void findProductName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> listProduct = this.productBO.findProductByCountry(name);
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }


    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listProduct = productBO.selectAllProducts();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingUser = productBO.selectProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("product", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String descriptions = request.getParameter("descriptions");
        String category = request.getParameter("category");

        Product newProduct = new Product(name, price, quantity, color, descriptions, category);
        productBO.insertProduct(newProduct);
        List<Product> listProduct = productBO.selectAllProducts();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String descriptions = request.getParameter("descriptions");
        String category = request.getParameter("category");

        Product book = new Product(id, name, price, quantity, color, descriptions, category);
        productBO.updateProduct(book);
        List<Product> listProduct = productBO.selectAllProducts();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productBO.selectProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        this.productBO.deleteProduct(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}