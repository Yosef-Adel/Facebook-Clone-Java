package com.facebookclonejava.service;

import com.facebookclonejava.controller.Request.CommentRequest;
import com.facebookclonejava.models.Comment;
import com.facebookclonejava.models.User;

import java.util.HashMap;
import java.util.List;

public interface CommentService {

    Comment createComment(CommentRequest commentRequest, User user);

    Comment updateComment(long id,CommentRequest commentRequest, User user);

    HashMap<String, Boolean> deleteComment(long id, User user);

    List<Comment> getCommentsOnPost(long id);


}
