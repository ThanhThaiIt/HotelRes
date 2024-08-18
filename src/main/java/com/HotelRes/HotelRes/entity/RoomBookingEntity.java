package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data// tự động tạo Getter Setter
@Entity(name = "room_booking")
public class RoomBookingEntity {
    @EmbeddedId
    private RoomBookingId id;

    @ManyToOne
    @MapsId("idRoom")
    @JoinColumn(name = "id_room")
    private RoomEntity roomEntity;

    @ManyToOne
    @MapsId("idBooking")
    @JoinColumn(name = "id_booking")
    private BookingEntity bookingEntity;

}


