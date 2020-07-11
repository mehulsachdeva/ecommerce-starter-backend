package com.service.eCommerceStarter.controllers;

import com.service.eCommerceStarter.services.PurchasesService.PurchasesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/service/api")
public class PurchasesController {
    @Autowired
    private PurchasesServiceImpl purchasesService;
}