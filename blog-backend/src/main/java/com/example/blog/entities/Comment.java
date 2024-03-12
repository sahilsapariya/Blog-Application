package com.example.blog.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    private String comment;


    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate createdOn;
    
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;

    public Comment() {
        this.createdOn = LocalDate.now();
    }

    public Comment(long id, String comment, LocalDate createdOn, Post post) {
        this.id = id;
        this.comment = comment;
        this.createdOn = LocalDate.now();
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    @JsonProperty("post")
    public void setPostId(Long postId) {
        if (postId != null) {
            this.post = new Post();
            this.post.setId(postId);
        }
    }

}
