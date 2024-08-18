package com.HotelRes.HotelRes.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity(name = "room_amenties")
public class RoomAmentiesEntity {

    @EmbeddedId
    private RoomAmentiesId id;


    @ManyToOne
    @MapsId("idRoomType")
    @JoinColumn(name = "id_room_type")
    private RoomTypeEntity roomTypeEntity;


    @ManyToOne
    @MapsId("idAmentities")
    @JoinColumn(name = "id_amentities")
    private AmenitiesEntity amenitiesEntity;





}
