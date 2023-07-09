package com.facebookclonejava.dao.impl;


import com.facebookclonejava.controller.Request.CommentRequest;
import com.facebookclonejava.dao.CommentDao;
import com.facebookclonejava.models.Comment;
import com.facebookclonejava.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CommentDaoImpl implements CommentDao
{
    private final CommentRepository commentReporsitory;

    @Override
    public Comment CreateComment(Comment comment) {

        return commentReporsitory.save(comment);
    }



    @Override
    public Comment updateComment(long id, CommentRequest comment) {
        Comment oldComment = commentReporsitory.findById(id).orElseThrow();


        // Update the properties of the old comment with the new comment data
        BeanUtils.copyProperties(comment, oldComment, "id", "user"); // Exclude copying the 'id' "user" field

        // Save the updated comment to the repository
        return commentReporsitory.save(oldComment);
    }

    @Override
    public boolean deleteComment(long id) {
        commentReporsitory.deleteById(id);
        return true;
    }



    @Override
    public List<Comment> getCommentByPost(long id) {
        return commentReporsitory.findUserByUserId(id);
    }


    @Override
    public Comment getCommentById(long id) {
        return commentReporsitory.findById(id).orElseThrow();
    }
}