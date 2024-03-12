package com.example.blog.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDate createdOn;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;    


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Post() {
        this.createdOn = LocalDate.now();
    }

    public Post(String title, String content, LocalDate createdOn) {
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
        this.createdOn = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}