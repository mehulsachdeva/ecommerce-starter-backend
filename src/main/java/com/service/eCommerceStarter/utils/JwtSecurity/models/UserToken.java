package com.service.eCommerceStarter.utils.JwtSecurity.models;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class UserToken {
    private Map<String, String> response = new LinkedHashMap<>();

    public UserToken(){
    }

    public Map<String, String> createTokenObject(String userId, String email, String token) {
        response.put("userId", userId);
        response.put("email", email);
        response.put("token", token);
        return response;
    }
}
