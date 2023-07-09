package com.facebookclonejava.dao.impl;

import com.facebookclonejava.dao.UserDao;
import com.facebookclonejava.models.User;
import com.facebookclonejava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * @created 06/07/2023 - 9:59 AM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;
    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean isEmailExist(String email) {
        return userRepository.existsUserByEmail(email);
    }
}
