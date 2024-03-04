package com.booking.dto.booking;

import com.booking.dto.user.UserDto;
import com.booking.model.Booking;
import com.booking.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingMapper {

    public static BookingResponseDto bookingToBookingResponseDto(Booking booking){
        return new BookingResponseDto(
                booking.getIdBooking(),
                booking.getNameHotel(),
                booking.getStartBooking(),
                booking.getEndBooking(),
                booking.getUserData()
                );
    }

    public static Booking bookingDtoToBooking(BookingDto bookingDto) {
        return new Booking(
                bookingDto.getNameHotel(),
                bookingDto.getUserData(),
                bookingDto.getDurationBooking()
                );
    }

}
