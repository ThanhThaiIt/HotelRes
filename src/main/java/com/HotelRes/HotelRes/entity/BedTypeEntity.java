package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "bed_type")
public class BedTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "bedTypeEntity")
    private List<RoomTypeEntity> roomTypeEntityList;
}
