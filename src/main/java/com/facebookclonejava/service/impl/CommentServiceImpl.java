package com.facebookclonejava.service.impl;

import com.facebookclonejava.controller.Request.CommentRequest;
import com.facebookclonejava.dao.impl.CommentDaoImpl;
import com.facebookclonejava.dao.impl.PostDaoImp;
import com.facebookclonejava.exception.UnAuthrized;
import com.facebookclonejava.models.Comment;
import com.facebookclonejava.models.Post;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentDaoImpl commentDao;
    private final PostDaoImp postDaoImp;

    @Override
    public Comment createComment(CommentRequest commentRequest, User user) {
        Post post=postDaoImp.getPostById(commentRequest.getPostId());

        Comment comment=new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setText(commentRequest.getText());
        return commentDao.CreateComment(comment);
    }

    @Override
    public Comment updateComment(long id,CommentRequest commentRequest, User user) {
        Comment comment=commentDao.getCommentById(id);
        if (!Objects.equals(comment.getUser().getId(), user.getId())) {
            throw new UnAuthrized("you not authrized to delete the post");
        }
        return commentDao.updateComment(id, commentRequest);
    }

    @Override
    public HashMap<String, Boolean>  deleteComment(long id, User user) {
        Comment comment=commentDao.getCommentById(id);
        if (!Objects.equals(comment.getUser().getId(), user.getId()) && !user.isAdmin()) {
            throw new UnAuthrized("you not authrized to delete the post");
        }
        HashMap<String, Boolean> stringBooleanHashMap = new HashMap<>();
        stringBooleanHashMap.put("Deleted", commentDao.deleteComment(id));
        return stringBooleanHashMap;

    }

    @Override
    public List<Comment> getCommentsOnPost(long id) {
        return  commentDao.getCommentByPost(id);
    }
}
