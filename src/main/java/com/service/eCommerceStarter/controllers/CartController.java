package com.service.eCommerceStarter.controllers;

import com.service.eCommerceStarter.services.CartService.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/service/api")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    @PostMapping("/cart/add/{userId}/{productId}/{quantity}")
    @PreAuthorize("@jwtUserSecurity.hasAccess(#userId, authentication)")
    public Map<String, String> addToCart(@PathVariable("userId") long userId, @PathVariable("productId") long productId, @PathVariable("quantity") int quantity) {
        return cartService.reserveProduct(userId, productId, quantity);
    }

    @PostMapping("/cart/remove/{userId}/{productId}")
    @PreAuthorize("@jwtUserSecurity.hasAccess(#userId, authentication)")
    public Map<String, String> removeToCart(@PathVariable("userId") long userId, @PathVariable("productId") long productId) {
        return cartService.unReserveProduct(userId, productId);
    }
}
