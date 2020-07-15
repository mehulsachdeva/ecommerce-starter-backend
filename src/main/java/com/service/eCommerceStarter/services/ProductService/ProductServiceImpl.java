package com.service.eCommerceStarter.services.ProductService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.eCommerceStarter.models.Filter;
import com.service.eCommerceStarter.models.Product;
import com.service.eCommerceStarter.services.Commons.Constants;
import com.service.eCommerceStarter.utils.ResponseBuilder.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ResponseBuilder responseBuilder;

    public Map<String, String> storeProduct(Product product) {
        try {
            productRepository.save(product);
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    Constants.STORE_PRODUCT_SUCCESS_RESPONSE,
                    Constants.NO_ERROR
            );
        }catch(Exception e){
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.STORE_PRODUCT_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> fetchProducts(Filter filter) {
        try {
            System.out.println(filter.toString());
            PageRequest pageRequest = PageRequest.of(filter.getPage(), Constants.PAGE_SIZE, Sort.by("productId").ascending());
            Page<Product> products = productRepository.findByNameContainingAndPriceBetween(filter.getName(), filter.getMin(), filter.getMax(), pageRequest);
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    new ObjectMapper().writeValueAsString(products),
                    Constants.NO_ERROR
            );
        }catch(Exception e){
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.FETCH_PRODUCTS_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> fetchProductById(long productId) {
        try {
            Optional<Product> productContainer = productRepository.findById(productId);
            if(productContainer.isPresent()) {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        new ObjectMapper().writeValueAsString(productContainer.get()),
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.NO_PRODUCT_FOUND_BY_ID,
                        Constants.NO_ERROR
                );
            }
        }catch(Exception e){
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.FETCH_PRODUCTS_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> updateProduct(Product product) {
        try {
            productRepository.save(product);
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    Constants.UPDATE_PRODUCT_SUCCESS_RESPONSE,
                    Constants.NO_ERROR
            );
        }catch(Exception e){
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.UPDATE_PRODUCT_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }
}
