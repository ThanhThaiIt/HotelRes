package com.HotelRes.HotelRes.controller;

import com.HotelRes.HotelRes.request.AuthenRequest;
import com.HotelRes.HotelRes.response.BaseResponse;
import com.HotelRes.HotelRes.service.UserService;
import com.HotelRes.HotelRes.utils.JwtHelper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/authen")
public class AuthenController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping
    public ResponseEntity<?> authen(@RequestBody AuthenRequest authenRequest) {

        boolean issucess = userService.registerUser(authenRequest);

        String token = issucess ? jwtHelper.generateToken(authenRequest.email()) : "fail authentication";

        BaseResponse baseResponse = new BaseResponse();

            baseResponse.setData(token);
        
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
