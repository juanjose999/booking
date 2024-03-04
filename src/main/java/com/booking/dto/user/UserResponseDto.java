package com.booking.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}