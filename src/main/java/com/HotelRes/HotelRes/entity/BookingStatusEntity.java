package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data// tự động tạo Getter Setter
@Entity(name = "booking_status")
public class BookingStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "bookingStatus")
    private List<BookingEntity> bookingEntityList;
}
