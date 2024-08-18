package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data// tự động tạo Getter Setter
@Entity(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_in")
    private Date check_in;

    @Column(name = "check_out")
    private Date check_out;

    @Column(name = "room_number")
    private Integer room_number;

    @ManyToOne
    @JoinColumn(name = "id_guest")
    private UserEntity user;

    @Column(name = "adult_number")
    private Integer adult_number;


    @Column(name = "children_number")
    private Integer children_number;

    @ManyToOne
    @JoinColumn(name = "id_payment_status")
    private PaymentStatusEntity paymentStatus;

    @ManyToOne
    @JoinColumn(name = "id_payment_method")
    private PaymentMethodEntity paymentMethod;

    @ManyToOne
    @JoinColumn(name = "id_status_booking")
    private BookingStatusEntity bookingStatus;


    @Column(name = "paid_amount")
    private Double paid_amount;
    @Column(name = "total")
    private Double total;


    @OneToMany(mappedBy = "bookingEntity")
    private List<RoomBookingEntity> roomBookingEntityList;


}
