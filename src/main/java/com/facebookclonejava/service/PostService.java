package com.facebookclonejava.service;

import com.facebookclonejava.controller.Request.PostRequest;
import com.facebookclonejava.models.Post;
import com.facebookclonejava.models.User;

import java.util.List;

public interface PostService {


    Post createPost(PostRequest postRequest, User uesr);


    Object deletePost(long id, User user);

    Post updatePost(long id, PostRequest post, User user);

    List<Post> getPosts(long id);

    List<Post> getPostsForTimeline(long id);

    Post getPostById(long id);

}
