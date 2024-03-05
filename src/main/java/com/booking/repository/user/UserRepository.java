package com.booking.repository.user;

import com.booking.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();
    User findUserById(String idUser);
    Optional<User> findByEmail(String email);
    User createUser(User user);
    User saveUser(User user);
    Boolean updateUser(String idUser, User user);
    Boolean deleteUserById(String idUser);
}
