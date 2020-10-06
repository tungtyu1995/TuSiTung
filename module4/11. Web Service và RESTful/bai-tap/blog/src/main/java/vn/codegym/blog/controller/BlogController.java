package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.service.BlogService;
import vn.codegym.blog.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogList = blogService.getAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(blogList,HttpStatus.OK);
        }
    }
    @PostMapping("/blog")
    public ResponseEntity addBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findStudentById(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @PutMapping("/blog/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog){
        Blog currentBlog = blogService.findById(id);
        if(currentBlog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentBlog.setTitleBlog(blog.getTitleBlog());
        currentBlog.setContentBlog(blog.getContentBlog());
        currentBlog.setCategory(blog.getCategory());

        blogService.save(currentBlog);

        return new ResponseEntity<>(currentBlog, HttpStatus.OK);
    }
    @DeleteMapping("/blog/{id}")
    public ResponseEntity deleteBlog(@PathVariable Long id){
        Blog blog=blogService.findById(id);
        blogService.remove(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
