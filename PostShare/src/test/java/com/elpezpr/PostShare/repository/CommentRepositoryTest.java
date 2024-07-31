package com.elpezpr.PostShare.repository;

import com.elpezpr.PostShare.model.Comment;
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
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    private Post post;
    private Comment comment;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setTitle("Test Title");
        post.setContent("Test Content");
        post.setAuthor("Test Author");
        post.setMetadata(new PostMetadata(LocalDateTime.now(), "Test Summary"));
        postRepository.save(post);

        comment = new Comment();
        comment.setContent("Test Comment");
        comment.setCreatedDate(LocalDateTime.now());
        comment.setAuthor("Comment Author");
        comment.setPost(post);

    }

    @Test
    void testSaveComment() {
        Comment savedComment = commentRepository.save(comment);
        assertNotNull(savedComment);
        assertNotNull(savedComment.getId());
    }

    @Test
    void testFindById() {
        Comment savedComment = commentRepository.save(comment);
        Optional<Comment> foundComment = commentRepository.findById(savedComment.getId());
        assertTrue(foundComment.isPresent());
        assertEquals("Test Comment", foundComment.get().getContent());
    }

    @Test
    void testFindByPostId() {
        Comment savedComment = commentRepository.save(comment);
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        assertFalse(comments.isEmpty());
        assertEquals("Test Comment", comments.get(0).getContent());
        assertEquals(post.getId(), comments.get(0).getPost().getId());
    }

    @Test
    void testDeleteById() {
        Comment savedComment = commentRepository.save(comment);
        commentRepository.deleteById(savedComment.getId());
        Optional<Comment> foundComment = commentRepository.findById(savedComment.getId());
        assertFalse(foundComment.isPresent());
    }
}