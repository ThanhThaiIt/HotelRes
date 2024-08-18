package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "amenities")
public class AmenitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "amenitiesEntity")
    private List<RoomAmentiesEntity> roomAmentiesEntityList;
}
