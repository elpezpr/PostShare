package com.elpezpr.PostShare.service.interfaces;

import com.elpezpr.PostShare.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> getAllPosts();
    Optional<Post> getPostById(Long id);
    List<Post> getPostsByAuthor(String author);
    Post savePost(Post post);
    Post updatePost(Long id, Post post);
    void updatePostContent(String content, Long id);
    void deletePostById(Long id);
}
