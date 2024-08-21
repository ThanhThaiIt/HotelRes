package com.HotelRes.HotelRes.service;

import com.HotelRes.HotelRes.dto.RoleDTO;
import com.HotelRes.HotelRes.entity.RoleEntity;
import com.HotelRes.HotelRes.request.AuthenRequest;

import java.util.List;

public interface UserService {

    List<RoleDTO> registerUser(AuthenRequest authenRequest);
}
