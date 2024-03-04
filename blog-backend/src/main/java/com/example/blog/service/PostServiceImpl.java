package com.example.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.dao.PostDao;
import com.example.blog.entities.Post;

@Service
public class PostServiceImpl implements PostServices {

    @Autowired
    private PostDao postDao;

    public PostServiceImpl() {
        
    }

    @Override
    public List<Post> getPosts() {
        return postDao.findAll();
    }

    @Override
    public Post getPost(long postId) {
        List<Post> posts = postDao.findAll();

        for (Post post : posts) {
            if (post.getId() == postId) {
                return post;
            }
        }
        return null;
    }

    @Override
    public Post addPost(Post post) {
        postDao.save(post);
        return post;
    }

    @Override
    public Post updatePost(Post post) {
        postDao.save(post);
        return post;
    }

    @Override
    public void deletePost(long postId) {
        try {
            Post post = postDao.getReferenceById(postId);
            postDao.delete(post);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
}
