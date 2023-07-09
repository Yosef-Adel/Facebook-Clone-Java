package com.facebookclonejava.controller;

import com.facebookclonejava.controller.Request.CommentRequest;
import com.facebookclonejava.models.Comment;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/Comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping()
    public Comment getUserData(@RequestBody CommentRequest commentRequest, Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        return commentService.createComment(commentRequest, (User) authentication.getPrincipal());
    }

    @DeleteMapping("/{id}")
    public HashMap<String, Boolean> delete(@PathVariable(name = "id") Long id, Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        return commentService.deleteComment(id, (User) authentication.getPrincipal());
    }

    @PatchMapping("/{id}")
    public Comment updateUserData(@PathVariable(name = "id") Long id, @RequestBody CommentRequest commentRequest, Authentication authentication) {
        return commentService.updateComment(id, commentRequest, (User) authentication.getPrincipal());
    }


    @GetMapping("/post/{id}")
    public List<Comment> getUserComment(@PathVariable(name = "id") Long id) {
        return commentService.getCommentsOnPost(id);
    }

}
