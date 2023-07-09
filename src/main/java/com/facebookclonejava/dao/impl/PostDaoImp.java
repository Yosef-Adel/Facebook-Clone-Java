package com.facebookclonejava.dao.impl;

import com.facebookclonejava.controller.Request.PostRequest;
import com.facebookclonejava.dao.PostDao;
import com.facebookclonejava.models.Post;
import com.facebookclonejava.repository.PostReporsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component
public class PostDaoImp implements PostDao {

    private final PostReporsitory postReporsitory;

    @Override
    public Post CreatePost(Post post) {

        return postReporsitory.save(post);
    }

    @Override
    public Post updatePost(long id, PostRequest post) {
        Post oldPost = postReporsitory.findById(id).orElseThrow();


        // Update the properties of the old post with the new post data
        BeanUtils.copyProperties(post, oldPost, "id", "user"); // Exclude copying the 'id' "user" field

        // Save the updated post to the repository
        return postReporsitory.save(oldPost);
    }

    @Override
    public boolean deletePost(long id) {
        postReporsitory.deleteById(id);
        return true;
    }

    @Override
    public List<Post> getPostByUer(long id) {
        return postReporsitory.getUserPosts(id);
    }

    @Override
    public Post getPostById(long id) {
        return postReporsitory.findById(id).orElseThrow();
    }
}
