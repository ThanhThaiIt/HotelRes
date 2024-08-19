package com.HotelRes.HotelRes.config;

import com.HotelRes.HotelRes.request.AuthenRequest;
import com.HotelRes.HotelRes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class CustomAuthenProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();


        AuthenRequest authenRequest = new AuthenRequest(username, password);
        boolean isSuccess = userService.registerUser(authenRequest);


        if (isSuccess) {
            return new UsernamePasswordAuthenticationToken("", "", new ArrayList<>());// trả về một authentication(chứng thực)
        }else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);// chấp nhận loại authentication là username và password
    }
}
