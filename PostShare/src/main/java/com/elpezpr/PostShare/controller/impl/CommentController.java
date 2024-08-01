package com.elpezpr.PostShare.controller.impl;

import com.elpezpr.PostShare.model.Comment;
import com.elpezpr.PostShare.service.impl.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentService commentService;

    // ********** POST **********

    @PostMapping("/comments")
    public Comment saveComment(@RequestBody @Valid Comment comment) {
        return commentService.saveComment(comment);
    }

    // ********** GET **********

    @GetMapping("/comments/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId) {
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        // If no comments found, return an empty list with a 200 status
        return ResponseEntity.ok(comments);
    }

    // ********** DELETE **********

    @DeleteMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommentById(@PathVariable Long id) {
        commentService.deleteCommentById(id);
    }
}