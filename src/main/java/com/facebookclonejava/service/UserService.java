package com.facebookclonejava.service;

import com.facebookclonejava.models.Role;
import com.facebookclonejava.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/*
 * @created 06/07/2023 - 10:08 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User addUser(User user);
    Role addRole(Role role);
    void attachRoleToUser(String userName, String roleName);
}
