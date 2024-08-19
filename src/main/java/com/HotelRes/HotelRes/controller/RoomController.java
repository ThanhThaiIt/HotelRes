package com.HotelRes.HotelRes.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    @GetMapping
    public ResponseEntity<?> addProduct(){

        return new ResponseEntity<>("hello room nhe", HttpStatus.OK);
    }
}
