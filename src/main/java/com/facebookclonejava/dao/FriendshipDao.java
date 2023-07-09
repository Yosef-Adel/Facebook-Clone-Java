package com.facebookclonejava.dao;

import com.facebookclonejava.models.Friendship;
import com.facebookclonejava.models.User;

import java.util.List;

/*
 * @created 09/07/2023 - 12:13 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
public interface FriendshipDao {
    List<User> getFriends(Long id);

    List<User> getRequests(Long id);


    void sendFriendRequest(Friendship friendship);

    Friendship findByUserIdAndFriendID(Long userId, Long friendId);


    Friendship updateFriendship(Friendship friendship);

    void deleteRequest(Friendship friendship);
}
