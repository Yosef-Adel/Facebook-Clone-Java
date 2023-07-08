package com.facebookclonejava.service.impl;

import com.facebookclonejava.controller.Request.PostRequest;
import com.facebookclonejava.dao.PostDaoImp;
import com.facebookclonejava.exception.UnAuthrized;
import com.facebookclonejava.models.Post;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDaoImp postDaoImp;


    @Override
    public Post createPost(PostRequest postRequest, User user) {

        Post newpost = new Post();
        newpost.setUser(user);
        newpost.setText(postRequest.getText());
        Post post = postDaoImp.CreatePost(newpost);
        return post;
    }

    @Override
    public HashMap<String, Boolean> deletePost(long id, User user) {

        Post post = postDaoImp.getPostById(id);
        if (!Objects.equals(post.getUser().getId(), user.getId()) && !user.isAdmin()) {
            throw new UnAuthrized("you not authrized to delete the post");
        }
        HashMap<String, Boolean> stringBooleanHashMap = new HashMap<>();
        stringBooleanHashMap.put("Deleted", postDaoImp.deletePost(id));
        return stringBooleanHashMap;

    }

    @Override
    public Post updatePost(long id, PostRequest UpdatePostRequest, User user) {
        Post post = postDaoImp.getPostById(id);
        if (!Objects.equals(post.getUser().getId(), user.getId()) && !user.isAdmin()) {
            throw new UnAuthrized("you not authrized to delete the post");
        }
        return postDaoImp.updatePost(id, UpdatePostRequest);
    }

    @Override
    public List<Post> getPosts(long id) {
        return postDaoImp.getPostByUer(id);
    }


}
