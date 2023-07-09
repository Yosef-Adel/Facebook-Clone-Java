package com.facebookclonejava.repository;

import com.facebookclonejava.models.Friendship;
import com.facebookclonejava.models.FriendshipId;
import com.facebookclonejava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, FriendshipId> {

//@Query("SELECT u FROM User u JOIN u.friendships f WHERE f.friend.id = :friendId AND f.status = :status")
    @Query("SELECT f.user FROM Friendship f WHERE f.friend.id= :userId  AND f.status = 0" )
    List<User> getRequests(Long userId);

    @Query("SELECT f.friend FROM Friendship f WHERE f.user.id = :userId AND f.status = 1 " +
            "UNION " +
            "SELECT f.user FROM Friendship f WHERE f.friend.id = :userId AND f.status = 1 ")
    List<User> getFriends(Long userId);

    Friendship findByUserIdAndFriend_Id(Long userId, Long friendId);









}
