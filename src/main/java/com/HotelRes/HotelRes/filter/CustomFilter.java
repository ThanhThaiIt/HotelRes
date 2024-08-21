package com.HotelRes.HotelRes.filter;

import com.HotelRes.HotelRes.dto.AuthorityDTO;
import com.HotelRes.HotelRes.utils.JwtHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomFilter extends OncePerRequestFilter {

    @Autowired
    private JwtHelper jwtHelper;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authenHeader = request.getHeader("Authorization");
        if (authenHeader != null && authenHeader.startsWith("Bearer ")) {
            String token = authenHeader.substring(7);
            String dataSubject = jwtHelper.decodeToken(token);
            System.out.println("kiem tra token da decode: " + dataSubject);

            if (dataSubject != null) {
                // list role đã được decode và chuyển nó về ListAuthorityDTO
                List<AuthorityDTO> authorityDTOList = objectMapper.readValue(dataSubject, new TypeReference<List<AuthorityDTO>>() {});



//                // tao mot list GrantedAuthority Rỗng
//                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
//                // vì chỉ "list GrantedAuthority" mới có thể truyền vào "dòng Tạo Xác Thực"
//                authorityDTOList.forEach(dataDTO -> {
//                    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(dataDTO.getAuthority());
//                    grantedAuthorityList.add(simpleGrantedAuthority);
//                });

                List<SimpleGrantedAuthority> simpleGrantedAuthorityList =
                        authorityDTOList.stream().map(authorityDTO -> new SimpleGrantedAuthority(authorityDTO.getAuthority())).toList();

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken("", "", simpleGrantedAuthorityList);// tạo xác thực
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }


}
