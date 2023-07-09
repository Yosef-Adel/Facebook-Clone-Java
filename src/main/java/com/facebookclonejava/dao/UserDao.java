package com.facebookclonejava.dao;

import com.facebookclonejava.models.User;

import java.util.Optional;

/*
 * @created 06/07/2023 - 9:56 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
public interface UserDao {
    Optional<User> findByEmail(String email);
    Optional<User> getUserById(Long id);
    User updateUser( User user);
    User addUser(User user);

    boolean isEmailExist(String email);
}
