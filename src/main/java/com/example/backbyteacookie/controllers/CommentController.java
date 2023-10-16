package com.example.backbyteacookie.controllers;

import com.example.backbyteacookie.models.Comment;
import com.example.backbyteacookie.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("comments")
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("")
    public List<Comment> listComments() {
        return commentService.findAll();
    }
    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.findById(id);
    }
}
