package com.booking.dto.booking;

import com.booking.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private String nameHotel;
    private int roomNumber;
    private LocalDateTime startBooking;
    private int durationBooking;
    private LocalDateTime endBooking;
    private List<User> userData;
}
