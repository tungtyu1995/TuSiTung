package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping({"", "/view"})
    public String show() {
        return "view";
    }

    @PostMapping("/view")
    public static ModelAndView search(@RequestParam String word) {
        ModelAndView modelAndView = new ModelAndView("view");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("read", "đọc");
        hashMap.put("book", "sách");
        hashMap.put("chicken", "con gà");
        hashMap.put("dog", "con chó");
        hashMap.put("cat", "con mèo");


        if (hashMap.get(word) == null) {
            word = "Mẹ mày nhập từ khó thế !!!";
        } else word = hashMap.get(word);
        modelAndView.addObject("result", word);
        return modelAndView;
    }
}
