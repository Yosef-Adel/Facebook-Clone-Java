package com.facebookclonejava.controller;

/*
 * @created 09/07/2023 - 1:59 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */

import com.facebookclonejava.controller.Request.FriendshipRequest;
import com.facebookclonejava.models.FriendStatus;
import com.facebookclonejava.models.Friendship;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.FriendshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/friends")
@RequiredArgsConstructor
public class FriendshipController {
    private final FriendshipService friendshipService;
    @PostMapping("/request")
    public String sendFriendRequest(
            @RequestBody FriendshipRequest friendshipRequest,
            Authentication authentication){
        Long userId = ((User) authentication.getPrincipal()).getId();
        friendshipService.sendFriendRequest(userId , friendshipRequest.getId());
        return "Send Request to User with Id:  " + friendshipRequest.getId() ;
    }

    @GetMapping("/requests")
    public List<User> getFriendRequests(Authentication authentication){
        Long userId = ((User) authentication.getPrincipal()).getId();
        return friendshipService.getAllFriendRequest(userId);
    }

    @PutMapping("/requests/{userId}/accept")
    public Friendship acceptFriendReq(Authentication authentication, @PathVariable("userId") Long userId ){
        Long friendId = ((User) authentication.getPrincipal()).getId();
        return friendshipService.updateFriendReq(userId, friendId, FriendStatus.ACCEPTED);
    }


    @DeleteMapping("/requests/{userId}/reject")
    public Friendship rejectFriendReq(Authentication authentication, @PathVariable("userId") Long userId ){
        Long friendId = ((User) authentication.getPrincipal()).getId();
        return friendshipService.deleteRequest(userId, friendId);
    }







}
