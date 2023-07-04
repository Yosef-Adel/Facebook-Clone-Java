package com.facebookclonejava.repository;

import com.facebookclonejava.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
