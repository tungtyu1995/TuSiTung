package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class SandwichController {
    @GetMapping()
    public String showHome(){
        return "show";
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam (required = false) String[] condiment ){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("condiment", condiment);
        if (condiment == null){
           modelAndView.addObject("msg", "chưa chọn gia vị");
        }
        return modelAndView;
    }
}
