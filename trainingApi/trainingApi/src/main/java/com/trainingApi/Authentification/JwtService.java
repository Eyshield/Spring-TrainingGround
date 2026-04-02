package com.trainingApi.Authentification;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {
    @Value("${jwt.secret_key}")
    private String secret_Key;
    @Value("${jwt.expiration_time}")
    private Long expration_Time;

    public String extractUserName(String token){
        return extractClaims(token, Claims::getSubject);
    }

    private <T>T extractClaims(String token, Function<Claims,T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);

    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Key getSigninKey() {
        byte[] key= Decoders.BASE64.decode(secret_Key);
        return Keys.hmacShaKeyFor(key);
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);

    }

    private String generateToken(Map<Object,String> extractClaims, UserDetails userDetails) {
        return buildToken(extractClaims,userDetails,expration_Time);
    }

    private String buildToken(Map<Object, String> extractClaims, UserDetails userDetails, Long exprationTime) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((System.currentTimeMillis())+exprationTime))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public Boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);

    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }


}
