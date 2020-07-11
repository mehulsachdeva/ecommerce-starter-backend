package com.service.eCommerceStarter.utils.JwtSecurity.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.eCommerceStarter.utils.JwtSecurity.models.JwtUser;
import com.service.eCommerceStarter.utils.JwtSecurity.models.UserToken;
import com.service.eCommerceStarter.utils.ResponseBuilder.ResponseBuilder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtGenerator {

    @Autowired
    private ResponseBuilder responseBuilder;

    @Autowired
    private UserToken userToken;

    public Map<String, String> generate(JwtUser jwtUser) {

        try {
            if(jwtUser != null) {
                Claims claims = Jwts.claims()
                        .setSubject(jwtUser.getEmail());
                claims.put("userId", String.valueOf(jwtUser.getUserId()));
                claims.put("role", jwtUser.getRole());

                String jwtGenerated = Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + Constants.JWT_TOKEN_EXPIRATION))
                        .signWith(SignatureAlgorithm.HS512, Constants.SECRET_KEY)
                        .compact();


                Map<String, String> tokenObject = userToken.createTokenObject(String.valueOf(jwtUser.getUserId()), jwtUser.getEmail(), jwtGenerated);

                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        new ObjectMapper().writeValueAsString(tokenObject),
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.FAILURE_STATUS,
                        Constants.EMPTY_JWT_GENERATED,
                        Constants.INVALID_CREDENTIALS_FOR_JWT_ERROR
                );
            }
        }catch(Exception e){
            return responseBuilder.createResponse(
                    Constants.FAILURE_STATUS,
                    Constants.GENERATION_JWT_TOKEN_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }
}