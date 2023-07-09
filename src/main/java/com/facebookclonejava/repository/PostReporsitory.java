package com.facebookclonejava.repository;

import com.facebookclonejava.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostReporsitory extends JpaRepository<Post, Long> {
    @Query(value = "SELECT *FROM POST P WHERE P.user_id=(:ID)", nativeQuery = true)
    List<Post> getUserPosts(@Param("ID") long id);


    @Query("SELECT p FROM Post p WHERE p.user.id=:userId or p.user.id IN "
            + "(SELECT f.friend.id FROM Friendship f WHERE f.user.id = :userId AND f.status = 1)"
            + " OR p.user.id IN "
            + "(SELECT fr.user.id FROM Friendship fr WHERE fr.friend.id = :userId AND fr.status = 1)")
    List<Post> getTimelinePost(@Param("userId") long userId);
}
