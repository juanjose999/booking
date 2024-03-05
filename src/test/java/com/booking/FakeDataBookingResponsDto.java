package com.booking;

import com.booking.dto.booking.BookingDto;
import com.booking.dto.booking.BookingResponseDto;
import com.booking.model.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FakeDataBookingResponsDto {

    public static BookingResponseDto getObject1() {
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        bookingResponseDto.setIdBooking("1");
        bookingResponseDto.setNameHotel("Grand Paradise Resort");
        bookingResponseDto.setStartBooking(LocalDateTime.now());
        bookingResponseDto.setEndBooking(LocalDateTime.now().plusDays(5));
        List<User> userDataList = new ArrayList<>();
        User user = new User("John", "Doe", "john.doe@example.com", "secure123");
        userDataList.add(user);
        bookingResponseDto.setUserData(userDataList);
        return bookingResponseDto;
    }

    public static BookingResponseDto getObject2() {
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        bookingResponseDto.setIdBooking("2");
        bookingResponseDto.setNameHotel("Luxury Beachfront Villa");
        bookingResponseDto.setStartBooking(LocalDateTime.now());
        bookingResponseDto.setEndBooking(LocalDateTime.now().plusDays(7));
        List<User> userDataList = new ArrayList<>();
        User user = new User("Alice", "Johnson", "alice.johnson@example.com", "strongPassword");
        userDataList.add(user);
        bookingResponseDto.setUserData(userDataList);
        return bookingResponseDto;
    }

    //this is BookingDto
    public static BookingDto getObject3() {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setNameHotel("Cozy Mountain Retreat");
        bookingDto.setStartBooking(LocalDateTime.now());
        bookingDto.setEndBooking(LocalDateTime.now().plusDays(3));

        List<User> userDataList = new ArrayList<>();
        User user = new User("Eva", "Smith", "eva.smith@example.com", "safePass123");
        userDataList.add(user);

        bookingDto.setUserData(userDataList);
        return bookingDto;
    }

}
