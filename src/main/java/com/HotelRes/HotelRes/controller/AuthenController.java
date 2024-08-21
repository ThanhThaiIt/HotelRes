package com.HotelRes.HotelRes.controller;

import com.HotelRes.HotelRes.request.AuthenRequest;
import com.HotelRes.HotelRes.response.BaseResponse;
import com.HotelRes.HotelRes.service.UserService;
import com.HotelRes.HotelRes.utils.JwtHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.List;

@RestController
@RequestMapping("/authen")
@CrossOrigin
public class AuthenController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<?> authen(@Valid @RequestBody AuthenRequest authenRequest) throws JsonProcessingException {



        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authenRequest.email(),authenRequest.password());

       Authentication authentication = authenticationManager.authenticate(authenticationToken);


        List<GrantedAuthority> listRole = (List<GrantedAuthority>) authentication.getAuthorities();

        String dataRole = objectMapper.writeValueAsString(listRole);// chuyển list thành String Json thông qua thư viện jakson

        System.out.println("DataRole: " + dataRole);

         String token =    jwtHelper.generateToken(dataRole);

        BaseResponse baseResponse = new BaseResponse();

            baseResponse.setData(token);
        
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
