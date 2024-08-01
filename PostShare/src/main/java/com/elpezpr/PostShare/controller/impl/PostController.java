package com.elpezpr.PostShare.controller.impl;

import com.elpezpr.PostShare.controller.dto.PostContentDTO;
import com.elpezpr.PostShare.model.Post;
import com.elpezpr.PostShare.service.impl.PostService;
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
public class PostController {
    @Autowired
    PostService postService;

    // ********** GET **********

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPostById(@PathVariable Long id) {
        return  postService.getPostById(id);
    }

    @GetMapping("/posts/author/{author}")
    public List<Post> getPostsByAuthor(@PathVariable String author) {
        return postService.getPostsByAuthor(author);
    }

    // ********** POST **********

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    // ********** PUT **********

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(id, post);
        if (updatedPost == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
        return updatedPost;
    }

    // ********** PATCH **********

    @PatchMapping("/posts/content/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePostContent(@RequestBody @Valid PostContentDTO postContentDTO, @PathVariable Long id) {
        postService.updatePostContent(postContentDTO.getContent(), id);
    }

    // ********** DELETE **********

    @DeleteMapping("/posts/{id}")
    public void deletePostById(@PathVariable Long id) {
        postService.deletePostById(id);
    }
}


