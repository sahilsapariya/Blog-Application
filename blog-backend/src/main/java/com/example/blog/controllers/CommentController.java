package com.example.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.blog.entities.Comment;
import com.example.blog.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "http://localhost:3000" , allowedHeaders = "*" , allowCredentials = "true")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.addComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
