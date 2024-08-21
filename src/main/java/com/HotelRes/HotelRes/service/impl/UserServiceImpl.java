package com.HotelRes.HotelRes.service.impl;

import com.HotelRes.HotelRes.dto.RoleDTO;
import com.HotelRes.HotelRes.entity.RoleEntity;
import com.HotelRes.HotelRes.entity.UserEntity;
import com.HotelRes.HotelRes.repository.UserRepository;
import com.HotelRes.HotelRes.request.AuthenRequest;
import com.HotelRes.HotelRes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<RoleDTO> registerUser(AuthenRequest authenRequest) {

        List<RoleDTO> roleEntityList = new ArrayList<>();


        UserEntity userEntity = userRepository.findUserEntityByEmail(authenRequest.email());

        if (userEntity != null && passwordEncoder.matches(authenRequest.password(), userEntity.getPassword())) {
            RoleEntity roleEntity = userEntity.getRole();
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(roleEntity.getId());
            roleDTO.setName(roleEntity.getName());

            roleEntityList.add(roleDTO);
        }
        return roleEntityList;
    }
}
