package com.facebookclonejava.dao.impl;

import com.facebookclonejava.dao.FriendshipDao;
import com.facebookclonejava.models.Friendship;
import com.facebookclonejava.models.User;
import com.facebookclonejava.repository.FriendshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 09/07/2023 - 12:57 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */

@Repository
@RequiredArgsConstructor
public class FriendshipDaoImpl implements FriendshipDao {
    private final FriendshipRepository friendshipRepository;

    @Override
    public List<User> getFriends(Long id) {
        return friendshipRepository.getFriends(id);
    }

    @Override
    public List<User> getRequests(Long id) {
        return friendshipRepository.getRequests(id);
    }

    @Override
    public void sendFriendRequest(Friendship friendship) {
        friendshipRepository.save(friendship);
    }

    @Override
    public Friendship findByUserIdAndFriendID(Long userId, Long friendId) {
        return friendshipRepository.findByUserIdAndFriend_Id(userId, friendId);
    }

    @Override
    public Friendship updateFriendship(Friendship friendship) {
        return friendshipRepository.save(friendship);
    }

    @Override
    public void deleteRequest(Friendship friendship) {
        friendshipRepository.delete(friendship);
    }
}
