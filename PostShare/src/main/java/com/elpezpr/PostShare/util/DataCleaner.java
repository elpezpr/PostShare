package com.elpezpr.PostShare.util;

import com.elpezpr.PostShare.repository.CommentRepository;
import com.elpezpr.PostShare.repository.PostRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataCleaner {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @PreDestroy
    public void  cleanUp(){
        commentRepository.deleteAll();
        postRepository.deleteAll();
    }
}
