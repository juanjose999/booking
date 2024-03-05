package com.booking.dto.booking;

import com.booking.model.booking.Booking;

public class BookingMapper {

    public static BookingResponseDto bookingToBookingResponseDto(Booking booking){
        return new BookingResponseDto(
                booking.getIdBooking(),
                booking.getNameHotel(),
                booking.getRoomNumber(),
                booking.getStartBooking(),
                booking.getEndBooking(),
                booking.getUserData()
                );
    }

    public static Booking bookingDtoToBooking(BookingDto bookingDto) {
        return new Booking(
                bookingDto.getNameHotel(),
                bookingDto.getRoomNumber(),
                bookingDto.getUserData(),
                bookingDto.getDurationBooking()
                );
    }

}
