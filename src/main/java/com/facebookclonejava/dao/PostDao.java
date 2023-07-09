package com.facebookclonejava.dao;

import com.facebookclonejava.controller.Request.PostRequest;
import com.facebookclonejava.models.Post;

import java.util.List;

public interface PostDao {

    Post CreatePost(Post post);

    Post updatePost(long id, PostRequest post);

    boolean deletePost(long id);

    List<Post> getPostByUer(long id);

    List<Post> getPostForTimeline(long id);

    Post getPostById(long id);


}
