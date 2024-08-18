package com.HotelRes.HotelRes.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @GetMapping("contho")
    public ResponseEntity<?> hello() {
        return new ResponseEntity<>("Hello demo con tho", HttpStatus.OK);
    }

    @GetMapping("conmeo")
    public ResponseEntity<?> hello2() {
        return new ResponseEntity<>("Hello demo con meo 2", HttpStatus.OK);
    }
}
