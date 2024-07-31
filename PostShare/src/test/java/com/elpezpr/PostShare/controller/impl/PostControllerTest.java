package com.elpezpr.PostShare.controller.impl;


import com.elpezpr.PostShare.model.Post;
import com.elpezpr.PostShare.model.PostMetadata;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
class PostControllerTest {
    @Autowired
    PostRepository postRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Post post;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        post = new Post();
        post.setTitle("Initial Title");
        post.setContent("Initial Content");
        post.setAuthor("Author");
        post.setMetadata(new PostMetadata()); // Ensure metadata is not null
        post = postRepository.save(post);

    }

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
    }



    @Test
    void getAllPosts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(post.getTitle()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(post.getContent()));
    }

    @Test
    void getPostById_validId_correctPost() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/posts/{id}", post.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();
        assertTrue(responseContent.contains(post.getTitle()));
        assertTrue(responseContent.contains(post.getContent()));
    }

    @Test
    void getPostById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/api/posts/{id}", 999L)) // Use an ID that doesn't exist
                .andExpect(status().isNotFound())
                .andReturn();
    }


}