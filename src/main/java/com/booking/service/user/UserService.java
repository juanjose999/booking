package com.booking.service.user;

import com.booking.dto.user.UserDto;
import com.booking.dto.user.UserResponseDto;
import com.booking.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto findUserById(String idUser);
    User findByEmail(String email);
    UserResponseDto createUser(UserDto userDto);
    UserResponseDto saveUser(UserDto userDto);
    Boolean updateUser(String idUser, UserDto userDto);
    Boolean deleteUser(String idUser);

}
