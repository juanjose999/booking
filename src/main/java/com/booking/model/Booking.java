package com.booking.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookings")
public class Booking implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    @Id
    private String idBooking;
    private String nameHotel;
    @DBRef
    @JsonManagedReference
    private List<User> userData;

    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm")
    private LocalDateTime startBooking;
    private int durationBooking;
    private LocalDateTime endBooking;

    public Booking(String nameHotel, List<User> userData, int durationBooking) {
        this.nameHotel = nameHotel;
        this.userData = userData != null ? userData:new ArrayList<>();
        this.startBooking = LocalDateTime.now();
        this.durationBooking = durationBooking;
        this.endBooking = startBooking.plusDays(durationBooking);
    }


}
