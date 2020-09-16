package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
//    @GetMapping("/customers")
//    public String showList() {
//        return "customers/list.jsp";
//    }

    private CustomerService customerService = CustomerServiceFactory.getInstance();

    @GetMapping("/customers")
    public String showList(HttpServletRequest request) {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        return "customers/list.jsp";
    }

    @PostMapping("/customers")
    public String edit(HttpServletRequest request) {
        Customer customer1 = new Customer();
        customer1.setName(request.getParameter("name"));
        customer1.setEmail(request.getParameter("email"));
        customer1.setAddress(request.getParameter("address"));

        Long id = Long.valueOf(request.getParameter("id"));
        customer1.setId(id);
        customerService.save(customer1);
        return "customers/list.jsp";

    }
}
