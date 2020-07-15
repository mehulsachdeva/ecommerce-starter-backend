package com.service.eCommerceStarter.controllers;

import com.service.eCommerceStarter.models.Filter;
import com.service.eCommerceStarter.models.Product;
import com.service.eCommerceStarter.services.ProductService.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/service/api")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/products")
    public Map<String, String> fetchProducts(@RequestBody final Filter filter) {
        return productService.fetchProducts(filter);
    }

    @PostMapping("/products/store")
    public Map<String, String> storeProduct(@RequestBody final Product product) {
        return productService.storeProduct(product);
    }

    @GetMapping("/product/{productId}")
    public Map<String, String> fetchProductById(@PathVariable("productId") long productId) {
        return productService.fetchProductById(productId);
    }

    @PostMapping("/products/update")
    public Map<String, String> updateProduct(@RequestBody final Product product) {
        return productService.updateProduct(product);
    }
}
