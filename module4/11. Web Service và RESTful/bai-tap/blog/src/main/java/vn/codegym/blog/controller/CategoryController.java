package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;
import vn.codegym.blog.service.BlogService;
import vn.codegym.blog.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ModelAndView listCategory() {
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("listCategory", categoryService.getAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("category/save")
    public String save(Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Saved category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/edit")
    public String update(Category category, RedirectAttributes redirect) {
        categoryService.update(category);
        redirect.addFlashAttribute("success", "Modified category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirect) {
        categoryService.remove(category);
        redirect.addFlashAttribute("success", "Removed category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ModelAndView("/error.404");
        }

        Iterable<Blog> blogs = blogService.findAllByCategory(category);

        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category", category);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
}