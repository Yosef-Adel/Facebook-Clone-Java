package com.facebookclonejava.repository;

import com.facebookclonejava.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT *FROM comment c WHERE c.user_id=(:ID)", nativeQuery = true)
    List<Comment> findUserByUserId(@Param("ID") long id);

}
