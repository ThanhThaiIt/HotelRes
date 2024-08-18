package com.HotelRes.HotelRes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RoomAmentiesId implements Serializable {

    @Column(name = "id_room_type")
    private Long idRoomType;

    @Column(name = "id_amentities")
    private Long idAmentities;
}
