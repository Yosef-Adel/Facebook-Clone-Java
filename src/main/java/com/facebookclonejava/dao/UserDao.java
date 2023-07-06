package com.facebookclonejava.dao;

import com.facebookclonejava.models.User;

/*
 * @created 06/07/2023 - 9:56 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
public interface UserDao {
    User findByEmail(String email);
    User updateUser( User user);
    User addUser(User user);
}
