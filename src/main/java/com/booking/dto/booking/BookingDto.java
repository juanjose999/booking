package com.booking.dto.booking;

import com.booking.dto.user.UserDto;
import com.booking.dto.user.UserResponseDto;
import com.booking.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private String nameHotel;
    private LocalDateTime startBooking;
    private int durationBooking;
    private LocalDateTime endBooking;
    private List<User> userData;
}
