package com.example.backbyteacookie.controllers;

import com.example.backbyteacookie.models.Comment;
import com.example.backbyteacookie.services.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("comments")
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("")
    @Operation(summary = "Get all existing reviews")
    public List<Comment> listComments() {
        return commentService.findAll();
    }

    @PostMapping("")
    @Operation(summary = "Create a new review")
    public void addComment(@RequestBody Comment comment) {}

    @GetMapping("/{id}")
    @Operation(summary = "Get a specific review by its ID")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove a specific review")
    public void deleteComment(@PathVariable Long id) {}

    @GetMapping("/byDate")
    @Operation(summary = "Get all reviews posted on a given date")
    public List<Comment> getCommentsByDate(@RequestParam LocalDate date) {return new ArrayList<>();}

    @GetMapping("/byRating")
    @Operation(summary = "Get all reviews with a given rating")
    public List<Comment> getCommentsByRating(@RequestParam Integer rating) {return new ArrayList<>();}
}
