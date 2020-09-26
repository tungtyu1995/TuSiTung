package vn.codegym.baitap2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.baitap2.model.Blog;
import vn.codegym.baitap2.service.BlogService;


@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public ModelAndView getListComment(@PageableDefault(value = 2) @SortDefault(sort = "time", direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("blogs", blogService.findAll(pageable));
        return modelAndView;
    }


    @GetMapping("/view-blog/{id}")
    public ModelAndView viewBlogs(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/create", "blog", new Blog());
    }


    @PostMapping("/create-blog")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("ok", "da dang ki thanh cong");
        return "redirect:/";
    }


    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public String updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.update(blog);
        return "redirect:/";
    }


    @GetMapping("/delete-blog/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/";
    }
}
