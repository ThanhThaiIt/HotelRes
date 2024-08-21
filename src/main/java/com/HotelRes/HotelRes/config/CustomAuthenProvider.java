package com.HotelRes.HotelRes.config;

import com.HotelRes.HotelRes.dto.RoleDTO;
import com.HotelRes.HotelRes.request.AuthenRequest;
import com.HotelRes.HotelRes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomAuthenProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();


        AuthenRequest authenRequest = new AuthenRequest(username, password);
        List<RoleDTO> roleDTOList = userService.registerUser(authenRequest);


        if (roleDTOList.size()>0) {

            // Basic Way

//            List<GrantedAuthority> authorities = new ArrayList<>();
//
//            roleDTOList.forEach(roleDTO -> {
//                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleDTO.getName());
//                authorities.add(authority);
//            });
            // Java 8 StreamAPI
            //map() : Cho phép biến đổi từ kiểu dữ liệu gốc thành kiểu dữ liệu khác trong quá trình duyệt mảng/ đối tượng

            List<SimpleGrantedAuthority> authorities = roleDTOList.stream().map(roleDTO -> new SimpleGrantedAuthority(roleDTO.getName())).toList();



            return new UsernamePasswordAuthenticationToken("", "", authorities);// trả về một authentication(chứng thực)
        }else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);// chấp nhận loại authentication là username và password
    }
}
