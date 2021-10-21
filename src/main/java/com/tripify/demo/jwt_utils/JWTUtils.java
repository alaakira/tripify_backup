package com.tripify.demo.jwt_utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.tripify.demo.consts.Keys;
import com.tripify.demo.exceptions.ExpiredJwtToken;
import com.tripify.demo.exceptions.InvalidTokenException;
import com.tripify.demo.strings.Messages;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtils {

    private static final long serialVersionUID = -2550185165626007488L;
    private static final long hours = 5;
    private static final long days = 30;
    public static final long JWT_TOKEN_VALIDITY = days * hours * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    //retrieve username from jwt token
    public String getPhoneFromToken(String token) throws ExpiredJwtToken {
        try {
            return JWT.decode(token).getSubject();
        }catch (Exception exception){
            throw new InvalidTokenException();
        }
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return JWT.decode(token).getExpiresAt();
    }

    //check if the token has expired
    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDetails userDetails, String type) {
        Map<String, String> claims = new HashMap<>();
        claims.put(Keys.USER_TYPE.getName(), type);
        return doGenerateToken(claims, userDetails.getUsername());
    }

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, String> claims, String subject) {
        JWTCreator.Builder builder = JWT.create();
        claims.forEach(builder::withClaim);
        return builder.withSubject(subject).withExpiresAt(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000)).sign(Algorithm.HMAC256(secret));
    }

    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = getPhoneFromToken(token);
        if (isTokenExpired(token))
            throw new TokenExpiredException(Messages.TOKEN_EXPIRED);
        return true;
//            return (username.equals(userDetails.getUsername()));
    }

    public String getTypeFromToken(String token) {
        return JWT.decode(token).getClaim(Keys.USER_TYPE.getName()).asString();
    }

    public boolean isValidToken(String token) {
        try {
            JWT.decode(token).getSubject();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
