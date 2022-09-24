package edu.mum.cs544.controllers;

import edu.mum.cs544.entities.Comment;
import edu.mum.cs544.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<Comment> getAll() {
        System.out.println("GetALL");
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    public Comment get(@PathVariable int id) {
        System.out.println("Get One");
        return commentService.get(id);
    }

    @PostMapping
    public RedirectView add(@RequestBody Comment comment) {
        commentService.add(comment);
        return new RedirectView("/comments/" + comment.getId());
    }

    @PutMapping
    public void update(@RequestBody Comment comment) {
        commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        commentService.delete((int) id);
    }

    @GetMapping("/getByPostId")
    public List<Comment> findByPostId(@RequestParam int postId) {
        return commentService.findByPostId((int) postId);
    }


    @DeleteMapping("/deleteByPostId")
    public void deleteByPostId(@RequestParam int postId) {
        commentService.deleteByPostId( postId);
    }

    @GetMapping("/getByComment")
    public List<Comment> findByPostId(@RequestParam String comment) {
        return commentService.findByCommentContaining(comment);
    }
}
