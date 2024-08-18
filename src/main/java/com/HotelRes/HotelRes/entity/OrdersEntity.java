package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "id_food")
    private FoodEntity foodEntity;


    @ManyToOne
    @JoinColumn(name = "id_reservation")
    private ReservationEntity reservationEntity;

    @Column(name = "quanlity")
    private Integer quanlity;

    @Column(name = "order_time")
    private Date order_time;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private OrderStatusEntity orderStatusEntity;
}
