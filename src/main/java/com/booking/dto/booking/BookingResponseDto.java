package com.booking.dto.booking;

import com.booking.dto.user.UserDto;
import com.booking.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDto {
    private String idBooking;
    private String nameHotel;
    private LocalDateTime startBooking;
    private LocalDateTime endBooking;
    private List<User> userData;

}
