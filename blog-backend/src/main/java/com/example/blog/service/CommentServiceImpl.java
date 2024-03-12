package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.dao.CommentDao;
import com.example.blog.entities.Comment;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment addComment(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void deleteComment(long commentId) {
        commentDao.deleteById(commentId);
    }
}
