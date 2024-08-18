package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "room_type")
public class RoomTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "overview")
    private String overview;

    @Column(name = "price")
    private String price;

    @Column(name = "area")
    private String area;

    @Column(name = "capacity")
    private String capacity;

    @OneToMany(mappedBy = "roomTypeEntity")
    private List<RoomEntity> roomEntities;

    @ManyToOne
    @JoinColumn(name = "id_bed_type")
    private BedTypeEntity bedTypeEntity;


    @Column(name = "images")
    private String images;

    @OneToMany(mappedBy = "roomTypeEntity")
    private List<RoomAmentiesEntity> roomAmentiesEntityList;
}
