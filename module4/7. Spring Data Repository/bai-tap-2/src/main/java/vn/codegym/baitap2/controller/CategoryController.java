package vn.codegym.baitap2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.baitap2.model.Blog;
import vn.codegym.baitap2.model.Category;
import vn.codegym.baitap2.service.CategoryService;

@RequestMapping("category")
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getListCategory(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("categorys", categoryService.findAll(pageable));
        return modelAndView;
    }


    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/view");
            modelAndView.addObject("blog", new Blog());
            modelAndView.addObject("category", category);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/category/create", "category", new Blog());
    }


    @PostMapping("/create-category")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("ok", "da dang ki thanh cong");
        return "redirect:/category/";
    }


    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-category")
    public String updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/category/";
    }


    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.remove(id);
        return "redirect:/";
    }

}
