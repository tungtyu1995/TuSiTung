package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping({"", "/view"})
    public String show() {
        return "view";
    }

    @PostMapping("/addition")
    public static ModelAndView addition(@RequestParam Double number1, Double number2) {
        Double result = number1 + number2;
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("result", result);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        return modelAndView;
    }

    @PostMapping("/subtraction")
    public static ModelAndView subtraction(@RequestParam Double number1, Double number2) {
        Double result = number1 - number2;
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("result", result);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        return modelAndView;
    }

    @PostMapping("/multiplication")
    public static ModelAndView multiplication(@RequestParam  Double number1, Double number2) {
        Double result = number1 * number2;
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("result", result);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        return modelAndView;
    }

    @PostMapping("/division")
    public static ModelAndView division(@RequestParam  Double number1, Double number2) {
        Double result = number1 / number2;
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("result", result);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        return modelAndView;
    }

}
