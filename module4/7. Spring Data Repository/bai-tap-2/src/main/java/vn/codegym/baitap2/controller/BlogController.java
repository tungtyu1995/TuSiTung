package vn.codegym.baitap2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.baitap2.model.Blog;
import vn.codegym.baitap2.model.Category;
import vn.codegym.baitap2.service.BlogService;
import vn.codegym.baitap2.service.CategoryService;


@RequestMapping("/blog")
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView getListComment(@PageableDefault(value = 2) @SortDefault(sort = "time", direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("blogs", blogService.findAll(pageable));
        return modelAndView;
    }


    @GetMapping("/view-blog/{id}")
    public ModelAndView viewBlogs(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/view");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        Iterable<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categorys", categoryList);
        modelAndView.addObject("blog", new Blog());
        return modelAndView;

    }


    @PostMapping("/create-blog")
    public String createBlog(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("ok", "da dang ki thanh cong");
        return "redirect:/blog";
    }


    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);

        if (blog == null) {
            throw new NullPointerException("Khong tim thay student");
        }
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("categoryList", categoryService.findAll());
        return modelAndView;

    }

    @PostMapping("/edit-blog")
    public String updateBlog(Blog blog) {
        blogService.update(blog);
        return "redirect:/blog";
    }


    @GetMapping("/delete-blog/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/blog";
    }

    @GetMapping("/search-blog")
    public ModelAndView searchByName(@RequestParam(value = "inputSearch") String inputSearch,@RequestParam(value = "search",defaultValue = "") String search, @SortDefault(sort = "time", direction = Sort.Direction.DESC) @PageableDefault(value = 2) Pageable pageable) {


        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("blogs", blogService.findAllByNameContaining(inputSearch, pageable));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchByNameCate(@RequestParam String cateName, String name, @SortDefault(sort = "time", direction = Sort.Direction.DESC) @PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("categoryList", categoryService.findAll());
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("blogs", blogService.findAllByCategoryAndNameContaining(cateName, name, pageable));
        return modelAndView;
    }
}
