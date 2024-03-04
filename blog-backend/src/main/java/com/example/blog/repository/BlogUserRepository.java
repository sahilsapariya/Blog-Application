package com.example.blog.repository;

import com.example.blog.entities.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogUserRepository extends JpaRepository<BlogUser, Long> {
    Optional<BlogUser> findByUserName(String userName);
}