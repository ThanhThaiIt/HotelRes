package com.HotelRes.HotelRes.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component// có thể sử dụng @Service hay @Security cũng đc nhưng không nên vì nó không đúng ý nghĩa, đưa lên ioc
public class JwtHelper {

    @Value("${jwts.keysecret}")
    private String keysecret;
    private long expiredTime = 15 * 60 * 1000;
    public String generateToken(String data) {

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(keysecret));
        Date d = new Date();// gét currenttime then sub with expiredTime that you want to set
        long currentDateMilis  = d.getTime()+expiredTime;
        Date expDate = new Date(currentDateMilis);
        System.out.println("Date "+expDate);
        String token = Jwts.builder().subject(data).signWith(key).setExpiration(expDate).compact();


        return token;
    }

    // giải mã token
    public String decodeToken(String token) {

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(keysecret));

       return Jwts.parser().verifyWith(key).build()
                .parseClaimsJws(token)
                .getPayload()
                .getSubject();

    }
}
