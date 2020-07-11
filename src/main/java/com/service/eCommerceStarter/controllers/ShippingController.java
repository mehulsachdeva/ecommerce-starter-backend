package com.service.eCommerceStarter.controllers;

import com.service.eCommerceStarter.models.ShippingDetails;
import com.service.eCommerceStarter.services.ShippingService.ShippingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/service/api")
public class ShippingController {

    @Autowired
    private ShippingServiceImpl shippingService;

    @PostMapping("/shipping/update")
    @PreAuthorize("@jwtUserSecurity.hasAccess(#shippingDetails, authentication)")
    public Map<String, String> updateShippingDetails(@RequestBody final ShippingDetails shippingDetails) {
        return shippingService.updateShippingDetails(shippingDetails);
    }

    @GetMapping("/shipping/fetch/{userId}")
    @PreAuthorize("@jwtUserSecurity.hasAccess(#userId, authentication)")
    public Map<String, String> fetchShippingDetails(@PathVariable("userId") long userId) {
        return shippingService.fetchShippingDetails(userId);
    }
}
