package com.elpezpr.PostShare.service.impl;

import com.elpezpr.PostShare.model.Comment;
import com.elpezpr.PostShare.repository.CommentRepository;
import com.elpezpr.PostShare.repository.PostRepository;
import com.elpezpr.PostShare.service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment saveComment(Comment comment) {
        if (comment == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment must not be null");
        }
        if (comment.getPost() == null || !postRepository.existsById(comment.getPost().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Associated post must exist");
        }
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found with id: " + id);
        }
        return optionalComment;
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        if (postId == null || !postRepository.existsById(postId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post with Id: " + postId + " not found");
        }
        List<Comment> comments = commentRepository.findByPostId(postId);
        if (comments.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No comments found for post with Id: " + postId);
        }
        return comments;
    }

    @Override
    public void deleteCommentById(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment with Id: " + id + " not found");
        }
        commentRepository.deleteById(id);
    }
}

