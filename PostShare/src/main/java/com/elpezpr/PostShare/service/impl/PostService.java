package com.elpezpr.PostShare.service.impl;

import com.elpezpr.PostShare.model.Post;
import com.elpezpr.PostShare.repository.PostRepository;
import com.elpezpr.PostShare.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getPostsByAuthor(String author) {
        return postRepository.findByAuthor(author);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        if (postRepository.existsById(id)) {
            post.setId(id);
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public void updatePostContent(String content, Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setContent(content);
            postRepository.save(post);
        }
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
