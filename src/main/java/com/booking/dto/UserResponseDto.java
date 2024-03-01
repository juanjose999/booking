package com.booking.dto;

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