package com.example.blog.entities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String comment;
    private LocalDate createdOn;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "blog_user_id")
    private BlogUser blogUser;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {
    }

    public Comment(String comment, LocalDate createdOn, BlogUser blogUser, Post post) {
        this.comment = comment;
        this.createdOn = createdOn;
        this.blogUser = blogUser;
        this.post = post;
    }

    public Comment updateContent(String content) {
        setComment(content);
        setCreatedOn(LocalDate.now());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public BlogUser getBlogUser() {
        return blogUser;
    }

    public void setBlogUser(BlogUser blogUser) {
        this.blogUser = blogUser;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public JsonNode asJson() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.createObjectNode()
                .put("id", id)
                .put("comment", comment)
                .put("createdOn", createdOn.toString())
                .put("blogUser", blogUser.getUserName());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", createdOn=" + createdOn +
                ", blogUser=" + blogUser.getUserName() +
                ", post=" + post.getTitle() +
                '}';
    }
}