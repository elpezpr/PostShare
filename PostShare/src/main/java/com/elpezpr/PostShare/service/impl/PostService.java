package com.elpezpr.PostShare.service.impl;

import com.elpezpr.PostShare.model.Post;
import com.elpezpr.PostShare.repository.PostRepository;
import com.elpezpr.PostShare.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        if (posts.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No posts found");
        }
        return posts;
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No post found with id: " + id);
        }
        return optionalPost;
    }

    @Override
    public List<Post> getPostsByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author name can't be empty");
        }
        List<Post> posts = postRepository.findByAuthor(author);
        if (posts.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No posts found by author: " + author);
        }
        return posts;
    }

    @Override
    public Post savePost(Post post) {
        if (post == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post must not be null");
        }
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID must not be null");
        }

        // Retrieve the existing post from the repository
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with Id: " + id + " not found"));

        // Update fields
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        existingPost.setAuthor(post.getAuthor());
        existingPost.setMetadata(post.getMetadata());

        // Save the updated post
        return postRepository.save(existingPost);
    }

    @Override
    public void updatePostContent(String content, Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with Id: " + id + " not found");
        }
        Post post = optionalPost.get();
        post.setContent(content);
        postRepository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        if (!postRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with Id: " + id + " not found");
        }
        postRepository.deleteById(id);
    }
}