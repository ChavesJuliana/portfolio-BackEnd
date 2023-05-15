/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author Juli
 */

public class TokenUtils {
       
    //No estoy segura de como generar el secret
    private static String secret =  "dsjkfsdjfksdfsdhjfhsdfhsdhfsjdfhsdjhfjsdfhdjshfjsdhfjsdhfjsdhfdjshf";
    private static int expiration = 3600;

    public static String createToken(String email, String usuario){
        
        long expirationTime = expiration * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        
        Map<String, Object> extra = new HashMap<>();
        extra.put("usuario", usuario);
        
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }
    
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
                Claims claims = Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        
        String email = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        
        } catch(JwtException e){
            return null;
        }
                
    }
    
            
}
