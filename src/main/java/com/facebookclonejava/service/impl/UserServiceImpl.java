package com.facebookclonejava.service.impl;

import com.facebookclonejava.controller.Request.UserRequest;
import com.facebookclonejava.dao.RoleDao;
import com.facebookclonejava.dao.UserDao;
import com.facebookclonejava.exception.DuplicateResourceException;
import com.facebookclonejava.exception.ResourceNotFoundException;
import com.facebookclonejava.models.Role;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * @created 06/07/2023 - 11:53 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User with email [%s] not found".formatted(email)));
    }

    @Override
    public User findById(Long id) {
        return userDao.getUserById(id).orElseThrow(()-> new ResourceNotFoundException("User with id [%s] not found".formatted(id)));
    }

    @Override
    public User addUser(UserRequest request) {
        if (userDao.isEmailExist(request.getEmail())){
            throw new DuplicateResourceException("Email Already Exists.....");
        }
        String pass = request.getPassword();
        String hashPass = passwordEncoder.encode(pass);
        request.setPassword(hashPass);
        User newuser = userDao.addUser(new User(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        ));
        this.attachRoleToUser(request.getEmail(), "ROLE_USER");
        return newuser;
    }



    @Override
    public Role addRole(Role role) {
        return roleDao.addRole(role);
    }




    @Override
    public void attachRoleToUser(String email, String roleName) {
        Role r = roleDao.findRoleByName(roleName);
        System.out.println("attachRoleToUser " + email);
        User u = this.findByEmail(email);
        u.addRole(r);
        userDao.updateUser(u);
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Email or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),user.mapRolesToAuthorities());
    }


}
