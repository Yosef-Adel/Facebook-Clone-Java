package com.facebookclonejava.repository;

import com.facebookclonejava.models.Post;
import com.facebookclonejava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostReporsitory  extends JpaRepository<Post,Long> {
    @Query(value = "SELECT *FROM POST P WHERE P.user_id=(:ID)", nativeQuery = true)
     List<Post> getUserPosts(@Param("ID") long id) ;

}
