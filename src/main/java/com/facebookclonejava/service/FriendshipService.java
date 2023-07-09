package com.facebookclonejava.service;

import com.facebookclonejava.models.FriendStatus;
import com.facebookclonejava.models.Friendship;
import com.facebookclonejava.models.User;

import java.util.List;

/*
 * @created 09/07/2023 - 12:59 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */

public interface FriendshipService {
    List<User> getFriendsByUserId(Long id);
    List<User> getAllFriendRequest(Long id);
    void sendFriendRequest(Long userId, Long friendId);

    Friendship updateFriendReq(Long userId, Long friendId, FriendStatus status) ;

    Friendship deleteRequest(Long userId, Long friendId);
}
