package controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(value = {"", "/view"})
    public String abc() {
        return "view";
    }

    @PostMapping(value = {"/view"})
    public ModelAndView currenCyonversion(HttpServletRequest request) throws IOException {
        double usd = Double.parseDouble(request.getParameter("usd"));
        double exchangeRate = Double.parseDouble(request.getParameter("exchangeRate"));
        double vnd = usd * exchangeRate;
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("usd", usd);
        modelAndView.addObject("vnd", vnd);
        return modelAndView;
    }

}
