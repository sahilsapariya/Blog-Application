package com.example.blog.dto;
import java.time.LocalDateTime;


public class SimplifiedCommentDTO {

    private long id;
    private String comment;
    private LocalDateTime createdOn;


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
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    // Constructors, getters, and setters
}

