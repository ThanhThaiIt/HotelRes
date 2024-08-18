package com.HotelRes.HotelRes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RoomBookingId implements Serializable {

    @Column(name = "id_room")
    private Long idRoom;

    @Column(name = "id_booking")
    private Long idBooking;

    // Equals and HashCode
}
