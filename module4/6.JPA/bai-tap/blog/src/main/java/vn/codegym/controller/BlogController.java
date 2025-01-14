package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Blog;
import vn.codegym.service.BlogService;


@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;


    @GetMapping("/")
    public String listBlog(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "/list";
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
        Blog blog = blogService.findById(id);
        blogService.remove(blog);
        return "redirect:/";
    }
    //    @GetMapping("/blogs")
//    public ModelAndView listBlogs(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "search",defaultValue = "")String search,@RequestParam(value = "searchCategogy",defaultValue = "all")String searchCategogy){
//        Page<Blog> blogs = null;
//        if ((search.equals("")) && searchCategogy.equals("all") ) {
//            blogs = blogService.findAll(pageable);
//        } else if(!search.equals("") && searchCategogy.equals("all")) {
//                blogs = blogService.findAllByNameContaining(search,pageable);
//            }else if (search.equals("") && !searchCategogy.equals("all")) {
//                blogs = blogService.findAllByCategory_Name(searchCategogy,pageable);
//            }
//        ModelAndView modelAndView = new ModelAndView("blog/blog/list");
//        modelAndView.addObject("categorys", categoryService.findAll());
//        modelAndView.addObject("blogs", blogs);
//        modelAndView.addObject("search", search);
//        return modelAndView;
//    }
}
