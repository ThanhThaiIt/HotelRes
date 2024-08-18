package com.HotelRes.HotelRes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FoodMenuId implements Serializable {

    @Column(name = "id_menu")
    private Long idMenu;

    @Column(name = "id_food")
    private Long idFood;

}
