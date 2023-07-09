package com.facebookclonejava.dao;

import com.facebookclonejava.controller.Request.CommentRequest;
import com.facebookclonejava.models.Comment;

import java.util.List;

public interface CommentDao {

    Comment CreateComment(Comment comment);


    Comment updateComment(long id, CommentRequest comment);

    boolean deleteComment(long id);

    List<Comment> getCommentByPost(long id);

    Comment getCommentById(long id);
}
