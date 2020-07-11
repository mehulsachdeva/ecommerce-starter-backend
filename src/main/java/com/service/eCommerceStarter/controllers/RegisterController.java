package com.service.eCommerceStarter.controllers;

import com.service.eCommerceStarter.models.User;
import com.service.eCommerceStarter.services.RegisterService.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/service")
public class RegisterController {

    @Autowired
    private RegisterServiceImpl registerService;

    @PostMapping("/register")
    public Map<String, String> registerUser(@RequestBody final User user) {
        return registerService.registerUser(user);
    }

    @GetMapping("/check/{email}")
    public Map<String, String> checkEmailIsRegistered(@PathVariable("email") String email) {
        return registerService.checkEmailIsRegistered(email);
    }
}
