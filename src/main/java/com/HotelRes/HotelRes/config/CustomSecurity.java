package com.HotelRes.HotelRes.config;


import com.HotelRes.HotelRes.filter.CustomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration// chạy tầng config trước tầng controller
@EnableWebSecurity// cho phép custom config
public class CustomSecurity {// Stop video at 1h:00, video 38




    // đây passwordencoder lên ioc để khi cần dùng chỉ cận autowired chứ k cần khởi tạo
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }


    //can thiệp vào luồng hoạt động của spring security
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, CustomAuthenProvider customAuthenProvider) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(customAuthenProvider)// dùng authentication manager để bắt buộc sử dụng Authenprovidercustom mà ta đã custom
                .build();
    }

    //,"MANAGER"
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, CustomFilter customFilter) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/authen","/hello/contho").permitAll();
                    request.requestMatchers("/room").hasAnyRole("ADMIN");
                    request.anyRequest().authenticated();

                })
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
