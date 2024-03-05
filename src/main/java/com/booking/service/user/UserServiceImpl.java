package com.booking.service.user;

import com.booking.dto.user.UserDto;
import com.booking.dto.user.UserMapper;
import com.booking.dto.user.UserResponseDto;
import com.booking.model.user.User;
import com.booking.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        userRepository.getAllUsers().forEach(user -> userResponseDtoList.add(UserMapper.userToUserResponseDto(user)));
        return userResponseDtoList;
    }

    @Override
    public UserResponseDto findUserById(String idUser) {
        return UserMapper.userToUserResponseDto(userRepository.findUserById(idUser));
    }

    @Override
    public User findByEmail(String email) {
        User userFound = userRepository.findByEmail(email).get();
        if (userFound != null){
            return userFound;
        }
        return null;
    }

    @Override
    public UserResponseDto createUser(UserDto userDto) {
        return UserMapper.userToUserResponseDto(userRepository.createUser(UserMapper.userDtoToUser(userDto)));
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        return UserMapper.userToUserResponseDto(userRepository.saveUser(UserMapper.userDtoToUser(userDto)));
    }

    @Override
    public Boolean updateUser(String idUser, UserDto userDto) {
        return userRepository.updateUser(idUser, UserMapper.userDtoToUser(userDto));
    }

    @Override
    public Boolean deleteUser(String idUser) {
        return userRepository.deleteUserById(idUser);
    }
}