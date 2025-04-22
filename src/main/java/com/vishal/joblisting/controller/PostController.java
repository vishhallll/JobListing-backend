package com.vishal.joblisting.controller;


import com.vishal.joblisting.repository.PostRepository;
import com.vishal.joblisting.model.Post;
import com.vishal.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController  {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;


    @GetMapping("/posts")
    public List<Post> getAllPosts()
    {
      return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> searchPost(@PathVariable String text)
    {
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }
}
