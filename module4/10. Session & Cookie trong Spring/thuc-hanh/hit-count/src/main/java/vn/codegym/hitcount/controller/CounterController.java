package vn.codegym.hitcount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.hitcount.model.MyCounter;

@Controller
@SessionAttributes("myCounter")
public class CounterController {

    @GetMapping("")
    public String getAbc(@ModelAttribute("myCounter") MyCounter myCounter ) {
        myCounter.increment();
        return "abcd/abc";
    }

    /* add MyCounter in model attribute */
    @ModelAttribute("myCounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }
}
