package com.booking.dto.user;

import com.booking.model.user.User;

public class UserMapper {
    public static UserResponseDto userToUserResponseDto(User user){
        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User userDtoToUser (UserDto userDto){
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getBirthDate(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }

    public static User userResponseDtoToUser(UserResponseDto userResponseDto){
        return new User(
                userResponseDto.getFirstName(),
                userResponseDto.getLastName(),
                userResponseDto.getBirthDate(),
                userResponseDto.getEmail(),
                userResponseDto.getPassword()
        );
    }
    public static UserDto userToUserDto (User user){
        return new UserDto(
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getEmail(),
                user.getPassword()
        );
    }
}