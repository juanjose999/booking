package com.booking.repository.user;

import com.booking.model.User;
import com.booking.repository.user.mongodb.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMongoRepository userMongoRepository;


    @Override
    public List<User> getAllUsers() {
        return userMongoRepository.findAll();
    }

    @Override
    public User findUserById(String idUser) {
        return userMongoRepository.findById(idUser).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        user.setUserRegistration(LocalDate.now());
        return userMongoRepository.save(user);
    }

    @Override
    public Boolean updateUser(String idUser, User user) {
        User searchUser = findUserById(idUser);
        if(searchUser != null){
            searchUser.setFirstName(user.getFirstName());
            searchUser.setLastName(user.getLastName());
            searchUser.setEmail(user.getEmail());
            searchUser.setPassword(user.getPassword());
            searchUser.setUserRegistration(searchUser.getUserRegistration());

            userMongoRepository.save(searchUser);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUserById(String idUser) {
        User existingId = findUserById(idUser);
        if(existingId != null){
            userMongoRepository.delete(existingId);
            return true;
        }
        return false;
    }

}
