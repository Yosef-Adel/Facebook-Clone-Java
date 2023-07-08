package com.facebookclonejava.controller;

import com.facebookclonejava.controller.Request.PostRequest;
import com.facebookclonejava.models.Post;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.impl.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostServiceImpl postService;

    @PostMapping()
    public Post getUserData(@RequestBody PostRequest postRequest, Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        return postService.createPost(postRequest, (User) authentication.getPrincipal());
    }

    @DeleteMapping("/{id}")
    public HashMap<String, Boolean> delete(@PathVariable(name = "id") Long id, Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        return postService.deletePost(id, (User) authentication.getPrincipal());
    }

    @PatchMapping("/{id}")
    public Post updateUserData(@PathVariable(name = "id") Long id, @RequestBody PostRequest postRequest, Authentication authentication) {
        return postService.updatePost(id, postRequest, (User) authentication.getPrincipal());
    }

    @GetMapping("/{id}")
    public List<Post> getUserPosts(@PathVariable(name = "id") Long id) {
        return postService.getPosts(id);
    }
}
