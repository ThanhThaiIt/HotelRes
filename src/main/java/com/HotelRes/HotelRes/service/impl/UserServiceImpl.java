package com.HotelRes.HotelRes.service.impl;

import com.HotelRes.HotelRes.entity.UserEntity;
import com.HotelRes.HotelRes.repository.UserRepository;
import com.HotelRes.HotelRes.request.AuthenRequest;
import com.HotelRes.HotelRes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean registerUser(AuthenRequest authenRequest) {

        boolean isSuccess = false;

        UserEntity userEntity = userRepository.findUserEntityByEmail(authenRequest.email());

        if (userEntity != null && passwordEncoder.matches(authenRequest.password(), userEntity.getPassword())) {
            isSuccess = true;
        }
        return isSuccess;
    }
}
