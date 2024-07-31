package com.elpezpr.PostShare.repository;

import com.elpezpr.PostShare.model.Post;
import com.elpezpr.PostShare.model.PostMetadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    private Post post;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setTitle("Test Title");
        post.setContent("Test Content");
        post.setAuthor("Test Author");
        post.setMetadata(new PostMetadata(LocalDateTime.now(), "Test Summary"));
    }

    @Test
    void testSavePost() {
        Post savedPost = postRepository.save(post);
        assertNotNull(savedPost);
        assertNotNull(savedPost.getId());
    }

    @Test
    void testFindById() {
        Post savedPost = postRepository.save(post);
        Optional<Post> foundPost = postRepository.findById(savedPost.getId());
        assertTrue(foundPost.isPresent());
        assertEquals("Test Title", foundPost.get().getTitle());
    }

    @Test
    void testFindByAuthor() {
        postRepository.save(post);
        List<Post> posts = postRepository.findByAuthor("Test Author");
        assertFalse(posts.isEmpty());
        assertEquals("Test Author", posts.get(0).getAuthor());
    }

    @Test
    void testDeleteById() {
        Post savedPost = postRepository.save(post);
        postRepository.deleteById(savedPost.getId());
        Optional<Post> foundPost = postRepository.findById(savedPost.getId());
        assertFalse(foundPost.isPresent());
    }


}