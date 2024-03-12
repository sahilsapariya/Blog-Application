package com.example.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.blog.entities.Post;
import com.example.blog.entities.PostWithComments;
import com.example.blog.service.PostServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class PostController {

    @Autowired
    private PostServices postServices;

    @GetMapping("posts")
    public List<Post> getPosts() {
        return this.postServices.getPosts();
    }

    @GetMapping("posts/{postId}")
    public PostWithComments getPost(@PathVariable long postId) {
        return this.postServices.getPostWithComments(postId);
    }

    @PostMapping("posts")
    public Post addPost(@RequestBody Post post) {
        return this.postServices.addPost(post);
    }

    @PutMapping("posts/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId, @RequestBody Post updatedPost) {
        Post existingPost = postServices.getPost(postId);

        if (existingPost == null) {
            return ResponseEntity.notFound().build();
        }

        // Preserve existing comments
        updatedPost.setComments(existingPost.getComments());

        // Update other fields of the post
        // For example, if you have title and content fields:
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());

        // Update the post in the database
        Post updatedPostEntity = postServices.updatePost(existingPost);

        return ResponseEntity.ok(updatedPostEntity);
    }

    @DeleteMapping("posts/{postId}")
    public void deletePost(@PathVariable long postId) {
        this.postServices.deletePost(postId);
    }
}
