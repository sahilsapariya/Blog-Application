package com.example.blog.service;

import com.example.blog.entities.Comment;


public interface CommentService {
    public Comment addComment(Comment comment);
    public void deleteComment(long commentId);
}
