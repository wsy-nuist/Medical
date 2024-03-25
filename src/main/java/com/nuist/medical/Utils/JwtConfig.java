package com.nuist.medical.Utils;

import com.nuist.medical.Pojo.Algorithm;
import com.nuist.medical.Pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-24-21:33
 * @Modified By:
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private String secret;

    private Long expire;

    public String generateJwt(User user){
        Map<String,Object> claims=new HashMap<>();
        Long timestamp=System.currentTimeMillis();
        Date beginDate=new Date(timestamp);
        Date expireDate=new Date(timestamp+expire);
        claims.put("user_id", user.getUser_id());
        String jwt= Jwts.builder().
                        addClaims(claims).
                        setIssuedAt(beginDate).
                        setExpiration(expireDate).
                        signWith(SignatureAlgorithm.HS256,secret).
                        compact();
        return jwt;
    }

    public Claims jwtParse(String token){
        Claims claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims;
    }


}
