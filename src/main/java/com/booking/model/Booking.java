package com.booking.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "bookings")
public class Booking implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
    @Id
    private String idBooking;
    private HotelEnum hotelEnum;
    @DBRef
    private List<User> userData;
    private LocalDate startBooking;
    private LocalDate endBooking;

}
