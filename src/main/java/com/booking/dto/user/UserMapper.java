package com.booking.dto.user;

import com.booking.model.User;

public class UserMapper {
    public static UserResponseDto userToUserResponseDto(User user){
        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User userDtoToUser (UserDto userDto){
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }

    public static User userResponseDtoToUser(UserResponseDto userResponseDto){
        return new User(
                userResponseDto.getFirstName(),
                userResponseDto.getLastName(),
                userResponseDto.getEmail(),
                userResponseDto.getPassword()
        );
    }
}