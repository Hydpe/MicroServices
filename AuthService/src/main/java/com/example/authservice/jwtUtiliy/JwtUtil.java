package com.example.authservice.jwtUtiliy;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "hduhdidhisuidhuhduuuhdgdggdtdtdttdtdttddvdvvdvdcdteersccrescscrcs";

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 600000)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject(); // the subject = email
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = getClaims(token); // parse token
            String email = claims.getSubject(); // extract subject (email)
            Date expiration = claims.getExpiration(); // get expiry date

            // check if token expired
            return (email != null && expiration.after(new Date()));
        }
        catch (ExpiredJwtException e) {
            System.out.println(" Token expired");
        } catch (MalformedJwtException e) {
            System.out.println(" Malformed token");
        }
        catch (Exception e) {
            System.out.println(" Invalid token: " + e.getMessage());
        }
        return false;
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody(); // gives payload (subject, issuedAt, expiration)
    }
}
