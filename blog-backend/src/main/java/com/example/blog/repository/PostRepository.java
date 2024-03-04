package com.example.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.entities.Post;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
}