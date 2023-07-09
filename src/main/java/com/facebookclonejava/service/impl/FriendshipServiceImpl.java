package com.facebookclonejava.service.impl;

import com.facebookclonejava.dao.FriendshipDao;
import com.facebookclonejava.models.FriendStatus;
import com.facebookclonejava.models.Friendship;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.FriendshipService;
import com.facebookclonejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.facebookclonejava.models.FriendStatus.PENDING;

/*
 * @created 09/07/2023 - 1:00 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
@Service
@RequiredArgsConstructor
public class FriendshipServiceImpl implements FriendshipService {
    private final FriendshipDao friendshipDao;
    private final UserService userService;
    @Override
    public List<User> getFriendsByUserId(Long id) {
        return friendshipDao.getFriends(id);
    }

    @Override
    public List<User> getAllFriendRequest(Long id) {
        return friendshipDao.getRequests(id);
    }

    @Override
    public void sendFriendRequest(Long userId, Long friendId) {
        User u = userService.findById(userId);
        User f = userService.findById(friendId);
        friendshipDao.sendFriendRequest(new Friendship(
                u,
                f,
                PENDING
        ));
    }

    @Override
    public Friendship updateFriendReq(Long userId, Long friendId, FriendStatus status) {
        Friendship f = friendshipDao.findByUserIdAndFriendID(userId, friendId);
        f.setStatus(status);
        return friendshipDao.updateFriendship(f);
    }

    @Override
    public Friendship deleteRequest(Long userId, Long friendId) {
        Friendship req = friendshipDao.findByUserIdAndFriendID(userId, friendId);
        friendshipDao.deleteRequest(req);
        return req;
    }
}
