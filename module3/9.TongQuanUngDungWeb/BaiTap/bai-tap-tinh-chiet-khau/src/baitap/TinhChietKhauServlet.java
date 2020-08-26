package baitap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TinhChietKhauServlet", urlPatterns = "/discount")
public class TinhChietKhauServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        double listPrice = Float.parseFloat(request.getParameter("listPrice"));
        double discountPercent = Float.parseFloat(request.getParameter("discountPercent"));

        double discountAmount = (listPrice * discountPercent * 0.01);
        double discountPrice = (listPrice + (listPrice * discountPercent * 0.01));

        request.setAttribute("productDescription", productDescription);
        request.setAttribute("listPrice", listPrice);
        request.setAttribute("discountPercent", discountPercent);
        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);

        request.getRequestDispatcher("result.jsp").forward(request, response);

        //        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println(" Product Description: " + productDescription);
//        writer.println("List Price: " + listPrice );
//        writer.println("Discount Percent " + discountPercent);
//        writer.println("Discount Amount" + (listPrice * discountPercent * 0.01));
//        writer.println("Discount Price" + (listPrice + (listPrice * discountPercent * 0.01)));
//        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
