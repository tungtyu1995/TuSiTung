import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculatorServletPath")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstOperand = request.getParameter("FirstOperand");
        String secondOperand = request.getParameter("SecondOperand");
        String operator = request.getParameter("Operator");
        Calculator calculator = new Calculator();
        double result = 0;
        try {
            result = calculator.calculate(Double.parseDouble(firstOperand),Double.parseDouble(secondOperand),operator);
        }catch (Exception e){
            e.getMessage();
        }
        request.setAttribute("resultServlet",result);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
