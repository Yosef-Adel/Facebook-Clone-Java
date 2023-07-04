package com.facebookclonejava.repository;

import com.facebookclonejava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
