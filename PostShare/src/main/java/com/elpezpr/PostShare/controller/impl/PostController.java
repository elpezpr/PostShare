package com.elpezpr.PostShare.controller.impl;

import com.elpezpr.PostShare.controller.dto.PostContentDTO;
import com.elpezpr.PostShare.model.Post;
import com.elpezpr.PostShare.service.impl.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService postService;

    // ********** GET **********

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postService.getPostById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/posts/author/{author}")
    public ResponseEntity<List<Post>> getPostsByAuthor(@PathVariable String author) {
        List<Post> posts = postService.getPostsByAuthor(author);
        return ResponseEntity.ok(posts);
    }

    // ********** POST **********

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return ResponseEntity.ok(savedPost);
    }

    // ********** PUT **********

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(id, post);
        return updatedPost != null ? ResponseEntity.ok(updatedPost) : ResponseEntity.notFound().build();
    }

    // ********** PATCH **********

    @PatchMapping("/posts/content/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePostContent(@RequestBody @Valid PostContentDTO postContentDTO, @PathVariable Long id) {
        postService.updatePostContent(postContentDTO.getContent(), id);
    }

    // ********** DELETE **********

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }
}

