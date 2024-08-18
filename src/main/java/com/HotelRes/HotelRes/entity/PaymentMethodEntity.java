package com.HotelRes.HotelRes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data// tự động tạo Getter Setter
@Entity(name = "payment_method")
public class PaymentMethodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "paymentMethod")
    private List<BookingEntity> bookingEntityList;
}
