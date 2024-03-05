package com.booking.repository.booking;

import com.booking.model.booking.Booking;
import com.booking.model.user.User;
import com.booking.repository.booking.mongodb.BookingMongoRepository;
import com.booking.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepositoryImpl implements BookingRepository {

    @Autowired
    private BookingMongoRepository bookingMongoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingMongoRepository.findAll();
    }

    @Override
    public Booking findBookingById(String idBooking) {
        Optional<Booking> optionalBooking = bookingMongoRepository.findById(idBooking);
        return optionalBooking.orElse(null);
    }
    @Override
    public Booking saveBooking(Booking booking) {
        // guarda el usuario que entre por booking
        List<User> savedUsers = new ArrayList<>();
        for (User user : booking.getUserData()) {
            User savedUser = userRepository.saveUser(user);
            savedUsers.add(savedUser);
        }

        // Set the saved users to the booking
        booking.setUserData(savedUsers);

        booking.setStartBooking(LocalDateTime.now());
        booking.setEndBooking(booking.getStartBooking().plusDays(booking.getDurationBooking()));

        // guardar booking
        return bookingMongoRepository.save(booking);
    }



    @Override
    public Boolean updateBooking(String idBooking, Booking booking) {
        Optional<Booking> searchBooking = bookingMongoRepository.findById(idBooking);
        if(searchBooking.isPresent()){
            Booking existingBooking = bookingMongoRepository.findById(idBooking).get();
            existingBooking.setNameHotel(booking.getNameHotel());
            existingBooking.setUserData(booking.getUserData());

            bookingMongoRepository.save(existingBooking);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBooking(String idBooking) {
        Optional<Booking> findBooking = bookingMongoRepository.findById(idBooking);
        if(findBooking.isPresent()){
            bookingMongoRepository.deleteById(idBooking);
            return true;
        }
        return false;
    }

}
