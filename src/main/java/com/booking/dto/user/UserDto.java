package com.booking.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data

public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String password;
    private LocalDate userRegistration;

    public UserDto(String firstName, String lastName, LocalDate birthDate,String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password=password;
    }
    public UserDto(String firstName, String lastName,String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password=password;
    }
}

