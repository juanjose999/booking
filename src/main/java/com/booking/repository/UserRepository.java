package com.booking.repository;

import com.booking.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
    User findUserById(String idUser);
    User saveUser(User user);
    Boolean updateUser(String idUser, User user);
    Boolean deleteUserById(String idUser);
}
