package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "reservation")
public class ReservationEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_guest")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "id_table")
    private TablesEntity tablesEntity;



    @Column(name = "guest_number")
    private Integer guest_number;


    @Column(name = "reservation_time")
    private Date reservation_time;

    @OneToMany(mappedBy = "reservationEntity")
    private List<OrdersEntity> ordersEntityList;





}
