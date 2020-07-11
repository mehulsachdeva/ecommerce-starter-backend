package com.service.eCommerceStarter.controllers;

import com.service.eCommerceStarter.utils.JwtSecurity.models.JwtUser;
import com.service.eCommerceStarter.utils.JwtSecurity.security.JwtGenerator;
import com.service.eCommerceStarter.utils.JwtSecurity.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/service")
public class LoginController {
    private JwtGenerator jwtGenerator;

    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    public LoginController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public Map<String, String> generate(@RequestBody final JwtUser jwtUser) {
        JwtUser fetchedJwtUser = loginService.authorizeUser(jwtUser);
        return jwtGenerator.generate(fetchedJwtUser);
    }
}
