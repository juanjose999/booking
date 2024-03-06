package com.booking.repository.user;

import com.booking.model.user.RoleEnum;
import com.booking.model.user.User;
import com.booking.repository.user.mongodb.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public Optional<User> findByEmail(String email) {
        Optional<User> userFound = userMongoRepository.findByEmail(email);
        if (userFound.isPresent()){
            return userFound;
        }else {
            return Optional.empty();
        }
    }

    @Override
    public User createUser(User user) {
        return userMongoRepository.save(user);
    }

    @Override
    public User saveUser(User user) {
        user.setUserRegistration(LocalDate.now());
        user.addRole(RoleEnum.USER);
        return userMongoRepository.save(user);
    }

    @Override
    public Boolean updateUser(String idUser, User user) {
        User searchUser = findUserById(idUser);
        if(searchUser != null){
            searchUser.setFirstName(user.getFirstName());
            searchUser.setLastName(user.getLastName());
            searchUser.setBirthDate(user.getBirthDate());
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
