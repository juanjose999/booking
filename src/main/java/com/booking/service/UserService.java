package com.booking.service;

import com.booking.dto.UserDto;
import com.booking.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto findUserById(String idUser);
    UserResponseDto saveUser(UserDto userDto);
    Boolean updateUser(String idUser, UserDto userDto);
    Boolean deleteUser(String idUser);

}
