package com.example.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.blog.entities.Post;
import com.example.blog.service.PostServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000" , allowedHeaders = "*" , allowCredentials = "true")
public class PostController {

    @Autowired
    private PostServices postServices;
    
    @GetMapping("posts")
    public List<Post> getPosts() {
        return this.postServices.getPosts();
    }
    
    @GetMapping("posts/{postId}")
    public Post getPost(@PathVariable long postId) {
        return this.postServices.getPost(postId);
    }
    
    @PostMapping("posts")
    public Post addPost(@RequestBody Post post) {
        return this.postServices.addPost(post);
    }
    
    
    @PutMapping("posts")
    public Post updatePost(@RequestBody Post post) {
        return this.postServices.updatePost(post);
    }

    @DeleteMapping("posts/{postId}")
    public void deletePost(@PathVariable long postId) {
        this.postServices.deletePost(postId);
    }
}
