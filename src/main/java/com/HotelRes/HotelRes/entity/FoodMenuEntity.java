package com.HotelRes.HotelRes.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data// tự động tạo Getter Setter
@Entity(name = "food_menu")
public class FoodMenuEntity {

    @EmbeddedId
    private FoodMenuId id;

    @ManyToOne
    @MapsId("idMenu")
    @JoinColumn(name = "id_menu")
    private MenuEntity menuEntity;


    @ManyToOne
    @MapsId("idFood")
    @JoinColumn(name = "id_food")
    private FoodEntity foodEntity;
}
