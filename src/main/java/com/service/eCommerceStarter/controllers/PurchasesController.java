package com.service.eCommerceStarter.controllers;

import com.service.eCommerceStarter.models.Purchases;
import com.service.eCommerceStarter.services.PurchasesService.PurchasesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/service/api")
public class PurchasesController {
    @Autowired
    private PurchasesServiceImpl purchasesService;

    @PostMapping("/purchase")
    @PreAuthorize("@jwtUserSecurity.hasAccess(#purchases, authentication)")
    public Map<String, String> makePurchase(@RequestBody final Purchases purchases) {
        return purchasesService.makePurchase(purchases);
    }

    @GetMapping("/purchase/history/{userId}")
    @PreAuthorize("@jwtUserSecurity.hasAccess(#userId, authentication)")
    public Map<String, String> fetchPurchaseHistoryById(@PathVariable("userId") long userId) {
        return purchasesService.fetchPurchaseHistoryById(userId);
    }

    @GetMapping("/purchases")
    public Map<String, String> fetchAllPurchases() {
        return purchasesService.fetchAllPurchases();
    }
}