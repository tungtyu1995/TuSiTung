package vn.codegym.userform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.userform.model.User;
import vn.codegym.userform.service.DuplicateEmailException;
import vn.codegym.userform.service.UserService;


@Controller
public class FormController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ModelAndView getListUser(@PageableDefault(value = 2) @SortDefault(sort = "lastName", direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/list");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("users", userService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;

    }


    @PostMapping("/create-user")
    public String createBlog(@Validated @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/user/create";
        } else {
            try {
                userService.save(user);
                redirectAttributes.addFlashAttribute("message", "da dang ki thanh cong");
                return "redirect:/";
            }catch (DuplicateEmailException e){
                return "/error";
            }

        }
    }

//try {
//        customerService.save(customer);
//        return new ModelAndView("redirect:/customers");
//    } catch () {
//        return new ModelAndView("customers/inputs-not-acceptable");
//    }


    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView("/user/edit");
            modelAndView.addObject("user", user);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-user")
    public String updateBlog( @Validated @ModelAttribute User user,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/edit";
        } else {
            userService.update(user);
            return "redirect:/";
        }
    }

}
