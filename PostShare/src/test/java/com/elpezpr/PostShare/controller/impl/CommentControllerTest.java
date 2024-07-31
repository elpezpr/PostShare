package com.elpezpr.PostShare.controller.impl;

import com.elpezpr.PostShare.model.Comment;
import com.elpezpr.PostShare.model.Post;
import com.elpezpr.PostShare.model.PostMetadata;
import com.elpezpr.PostShare.repository.CommentRepository;
import com.elpezpr.PostShare.repository.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class CommentControllerTest {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Post post;
    Comment comment;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        post = new Post();
        post.setTitle("Post Title");
        post.setContent("Post Content");
        post.setAuthor("Author");
        post.setMetadata(new PostMetadata()); // Ensure metadata is not null
        post = postRepository.save(post);

        comment = new Comment();
        comment.setContent("This is a comment.");
        comment.setPost(post);
        comment = commentRepository.save(comment);
    }

    @AfterEach
    void tearDown() {
        commentRepository.deleteAll();
        postRepository.deleteAll();
    }


    @Test
    void getCommentById_validId_correctComment() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/comments/{id}", comment.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();
        assertTrue(responseContent.contains(comment.getContent()));
    }
}