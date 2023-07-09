package com.facebookclonejava.controller;

/*
 * @created 09/07/2023 - 11:54 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */

import com.facebookclonejava.models.User;
import com.facebookclonejava.service.FriendshipService;
import com.facebookclonejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final FriendshipService friendshipService;

    @GetMapping("/me")
    public User getMyData(Authentication authentication){
        return ((User) authentication.getPrincipal());
    }

    @GetMapping("{id}")
    public User getUserData(@PathVariable("id") Long id){
        return userService.findById(id);
    }
    
    @GetMapping("/{id}/friends")
    public List<User> getFriends(@PathVariable("id") Long id){
        return friendshipService.getFriendsByUserId(id);
    }






}
