package com.facebookclonejava.repository;

import com.facebookclonejava.models.Friendship;
import com.facebookclonejava.models.FriendshipId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<Friendship, FriendshipId> {
}
