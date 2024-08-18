package com.HotelRes.HotelRes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity(name = "tables")
public class TablesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "tablesEntity")
    private List<ReservationEntity> reservationEntityList;
}
