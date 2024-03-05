package com.booking.repository.booking.mongodb;

import com.booking.model.booking.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingMongoRepository extends MongoRepository<Booking, String> {
}
