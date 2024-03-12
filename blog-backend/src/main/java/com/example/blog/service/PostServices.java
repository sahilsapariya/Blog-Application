package com.example.blog.service;

import java.util.List;


import com.example.blog.entities.Post;
import com.example.blog.entities.PostWithComments;

public interface PostServices {
    public List<Post> getPosts();
    public PostWithComments getPostWithComments(long postId);
    public Post getPost(long postId);
    public Post addPost(Post post);
    public Post updatePost(Post post);
    public void deletePost(long postId);
}
