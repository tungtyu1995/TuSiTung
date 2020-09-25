package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Comment;
import vn.codegym.service.CommentService;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("")
    public ModelAndView showCreateComment() {
        return new ModelAndView("create-comment", "comment", new Comment());
    }

    @PostMapping("/create-comment")
    public ModelAndView saveComment(@ModelAttribute("comment") Comment comment) {
        comment.setTotalLike(0L);
        commentService.save(comment);
        return new ModelAndView("create-comment", "comments", commentService.findAll());
    }

    @GetMapping("/list-comment")
    public ModelAndView getListComment() {
        return new ModelAndView("create-comment", "comments", commentService.findAll());
    }

    @GetMapping("/update-like/{id}")
    public ModelAndView updateLike(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("create-comment");
        Comment comment = commentService.findById(id);
        comment.setTotalLike(comment.getTotalLike() + 1);
        commentService.update(comment);
        modelAndView.addObject("comments", commentService.findAll());
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @GetMapping("/delete-like/{id}")
    public ModelAndView deleteComment(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("create-comment");
        Comment comment = commentService.findById(id);
        commentService.remove(comment);
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("comments", commentService.findAll());
        return modelAndView;
    }

}
