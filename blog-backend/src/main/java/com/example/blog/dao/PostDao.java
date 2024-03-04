package com.example.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.entities.Post;

public interface PostDao extends JpaRepository<Post, Long> {
    
}
