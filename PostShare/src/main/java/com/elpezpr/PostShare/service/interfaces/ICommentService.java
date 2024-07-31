package com.elpezpr.PostShare.service.interfaces;

import com.elpezpr.PostShare.model.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    Comment saveComment(Comment comment);
    Optional<Comment> getCommentById(Long id);
    List<Comment> getCommentsByPostId(Long postId);
    void deleteCommentById(Long id);
}
