package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data// tự động tạo Getter Setter
@Entity(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "roomEntity")
    private List<RoomBookingEntity> roomBookingEntityList;


    @ManyToOne
    @JoinColumn(name = "id_room_type")
    private RoomTypeEntity roomTypeEntity;

}
