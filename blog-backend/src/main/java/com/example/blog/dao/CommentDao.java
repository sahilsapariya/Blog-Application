package com.example.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.entities.Comment;
import com.example.blog.entities.Post;


public interface CommentDao extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
