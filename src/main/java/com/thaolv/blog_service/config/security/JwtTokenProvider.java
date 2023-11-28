package com.thaolv.blog_service.config.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenProvider {
    @Value("${secret.key}")
    private String APPLICATION_JWT_SECRET_KEY;

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 72 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, APPLICATION_JWT_SECRET_KEY).compact();
    }
    //kiểm tra nếu token hết hạn
    private Boolean isTokenExpired(String token) {
        final Date expiration = getAllClaimsFromTokens(token).getExpiration();
        return expiration.before(new Date());
    }

    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = this.getAllClaimsFromTokens(token).getSubject();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Claims getAllClaimsFromTokens(String requestTokenHeader) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(APPLICATION_JWT_SECRET_KEY)
                    .parseClaimsJws(requestTokenHeader)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
