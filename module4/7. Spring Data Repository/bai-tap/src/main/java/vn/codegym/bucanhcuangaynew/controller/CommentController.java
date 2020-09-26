package vn.codegym.bucanhcuangaynew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.bucanhcuangaynew.model.Comment;
import vn.codegym.bucanhcuangaynew.service.CommentService;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("")
    public ModelAndView getListComment(@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("create-comment");
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("comments", commentService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/create-comment")
    public String saveComment(@ModelAttribute("comment") Comment comment) {
        comment.setTotalLike(0L);
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("/update-like/{id}")
    public String updateLike(@PathVariable("id") Long id) {
        Comment comment = commentService.findById(id);
        comment.setTotalLike(comment.getTotalLike() + 1);
        commentService.update(comment);
        return "redirect:/";
    }

    @GetMapping("/delete-like/{id}")
    public String deleteComment(@PathVariable("id") Long id) {
        commentService.remove(id);
        return "redirect:/";
    }
}
