package com.example.lhtjwtlogin.security.jwt;

import com.example.lhtjwtlogin.security.Principle.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret ="chinh.nguyen@codegym.vn";
    private int jwtExpiration = 86400;

    public String createToken(Authentication authentication){
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512,jwtSecret)
                .compact();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (SignatureException e){
            logger.error("Invalid JWT signature -> Message: {}",e);
        }catch (MalformedJwtException e){
            logger.error("The token invalid format-> Message: {}",e);
        }catch (UnsupportedJwtException e){
            logger.error("Unsupported JWT token-> Message: {}",e);
        }catch (ExpiredJwtException e){
            logger.error("Expired JWT token> Message: {}",e);
        }catch (IllegalArgumentException e){
            logger.error("Jwt claims string is empty> Message: {}",e);
        }
        return false;
    }

    public String getUserNameFormToken(String token){
        String username = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return username;
    }
}
