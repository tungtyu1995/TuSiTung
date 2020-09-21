package vn.codegym.controllers;

import vn.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.EmailService;
import vn.codegym.service.EmailServiceImpl;

import java.util.List;

@RequestMapping({"","/email"})
@Controller
public class EmailController {

//    @Autowired
//    private EmailService emailService;

    private EmailService emailService = new EmailServiceImpl();

    @GetMapping("")
    public ModelAndView getEmailPage() {
        return new ModelAndView("list", "emails", emailService.findAll());
    }

    @GetMapping("/delete/{id}")
    public String deleteEmail(@PathVariable Integer id) {
        emailService.delete(id);
        return "redirect:/email";
    }


    @GetMapping("/create")
    public ModelAndView showForm(Model model) {
        List<String> listLanguage = emailService.getLanguage();
        List<String> listPageSize = emailService.getPageSize();
        model.addAttribute("listLanguage", listLanguage);
        model.addAttribute("listPageSize", listPageSize);
        return new ModelAndView("create", "email", new Email());
    }

    @PostMapping("/create")
    public String getAddEmail(@ModelAttribute Email email) {
        emailService.save(email);
        return "redirect:/email";
    }


    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable Integer id, Model model) {
        Email email = emailService.findById(id);
        List<String> listLanguage = emailService.getLanguage();
        List<String> listPageSize = emailService.getPageSize();
        model.addAttribute("listLanguage", listLanguage);
        model.addAttribute("listPageSize", listPageSize);
        return new ModelAndView("edit", "email", email);
    }

    @PostMapping("/edit")
    public String getEditStudent(@ModelAttribute Email email) {
        emailService.save(email);
        return "redirect:/email";
    }
}
