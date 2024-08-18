package com.HotelRes.HotelRes.controller;

import com.HotelRes.HotelRes.request.AuthenRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authen")
public class AuthenController {

    @PostMapping
    public ResponseEntity<?> authen(@RequestBody AuthenRequest authenRequest) {

        return new ResponseEntity<>(authenRequest, HttpStatus.OK);
    }

}
