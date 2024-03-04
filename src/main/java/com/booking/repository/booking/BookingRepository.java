package com.booking.repository.booking;

import com.booking.dto.booking.BookingDto;
import com.booking.dto.booking.BookingResponseDto;
import com.booking.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    List<Booking> getAllBookings();
    Booking findBookingById(String idBooking);
    Booking saveBooking(Booking booking);
    Boolean updateBooking(String idBooking, Booking booking);
    Boolean deleteBooking(String idBooking);
}
