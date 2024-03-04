package com.booking.service.booking;

import com.booking.dto.booking.BookingDto;
import com.booking.dto.booking.BookingMapper;
import com.booking.dto.booking.BookingResponseDto;
import com.booking.dto.user.UserDto;
import com.booking.dto.user.UserMapper;
import com.booking.dto.user.UserResponseDto;
import com.booking.model.Booking;
import com.booking.repository.booking.BookingRepository;
import com.booking.service.user.UserService;
import com.mongodb.client.model.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<BookingResponseDto> getAllBooking() {
        List<BookingResponseDto> responseDtoList = new ArrayList<>();
        bookingRepository.getAllBookings().forEach(booking -> responseDtoList.add(BookingMapper.bookingToBookingResponseDto(booking)));
        return responseDtoList;
    }

    @Override
    public BookingResponseDto findBookingById(String idBooking) {
        return BookingMapper.bookingToBookingResponseDto(bookingRepository.findBookingById(idBooking));
    }

    @Override
    public BookingResponseDto saveBooking(BookingDto bookingDto) {
        return BookingMapper.bookingToBookingResponseDto(bookingRepository.saveBooking(BookingMapper.bookingDtoToBooking(bookingDto)));
    }

    @Override
    public BookingResponseDto saveBookingWithUser(BookingDto bookingDto) {
        // Save the user along with the booking
        UserDto userDto = new UserDto(
                bookingDto.getUserData().get(0).getFirstName(),
                bookingDto.getUserData().get(0).getLastName(),
                bookingDto.getUserData().get(0).getEmail(),
                bookingDto.getUserData().get(0).getPassword()
        );

        UserResponseDto savedUser = userService.saveUser(userDto);

        // Create a new BookingDto with the saved user
        BookingDto newBookingDto = new BookingDto(
                bookingDto.getNameHotel(),
                bookingDto.getStartBooking(),
                bookingDto.getDurationBooking(),
                bookingDto.getEndBooking(),
                Collections.singletonList(UserMapper.userResponseDtoToUser(savedUser))
                );

        // Save the booking with the updated BookingDto
        return BookingMapper.bookingToBookingResponseDto(bookingRepository.saveBooking(BookingMapper.bookingDtoToBooking(newBookingDto)));
    }



    @Override
    public Boolean updateBooking(String idBooking, BookingDto bookingDto) {
        return bookingRepository.updateBooking(idBooking, BookingMapper.bookingDtoToBooking(bookingDto));
    }

    @Override
    public Boolean deleteBooking(String idBooking) {
        return bookingRepository.deleteBooking(idBooking);
    }
}
