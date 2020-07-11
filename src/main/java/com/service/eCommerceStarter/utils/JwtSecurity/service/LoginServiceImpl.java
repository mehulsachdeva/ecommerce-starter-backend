package com.service.eCommerceStarter.utils.JwtSecurity.service;

import com.service.eCommerceStarter.utils.JwtSecurity.models.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl {
    @Autowired
    private LoginRepository loginRepository;

    public JwtUser authorizeUser(JwtUser jwtUser) {
        try {
            Optional<JwtUser> jwtUserContainer = loginRepository.findByEmailAndPassword(jwtUser.getEmail(), jwtUser.getPassword());
            if (jwtUserContainer.isPresent()) {
                return jwtUserContainer.get();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
