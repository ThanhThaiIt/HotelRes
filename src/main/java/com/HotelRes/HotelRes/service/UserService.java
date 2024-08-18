package com.HotelRes.HotelRes.service;

import com.HotelRes.HotelRes.request.AuthenRequest;

public interface UserService {

    boolean registerUser(AuthenRequest authenRequest);
}
