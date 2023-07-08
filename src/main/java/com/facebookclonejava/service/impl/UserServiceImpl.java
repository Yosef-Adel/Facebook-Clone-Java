package com.facebookclonejava.service.impl;

import com.facebookclonejava.dao.RoleDao;
import com.facebookclonejava.dao.UserDao;
import com.facebookclonejava.models.Role;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

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
        return userDao.findByEmail(email);
    }

    @Override
    public User addUser(User user) {
        String pass = user.getPassword();
        String hashPass = passwordEncoder.encode(pass);
        user.setPassword(hashPass);
        User newuser = userDao.addUser(user);
        this.attachRoleToUser(user.getEmail(), "ROLE_USER");
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
        User u = userDao.findByEmail(email);
        u.addRole(r);
        userDao.updateUser(u);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Email or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));


    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}
