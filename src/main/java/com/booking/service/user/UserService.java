package com.booking.service.user;

import com.booking.dto.user.UserDto;
import com.booking.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto findUserById(String idUser);
    UserResponseDto saveUser(UserDto userDto);
    Boolean updateUser(String idUser, UserDto userDto);
    Boolean deleteUser(String idUser);

}
