package com.service.eCommerceStarter.services.CartService;

import com.service.eCommerceStarter.services.Commons.Constants;
import com.service.eCommerceStarter.utils.Classes.Purchase;
import com.service.eCommerceStarter.utils.Classes.User;
import com.service.eCommerceStarter.utils.ResponseBuilder.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ResponseBuilder responseBuilder;

    public Map<String, String> reserveProduct(long userId, long productId, int requestedQuantity) {
        try {
            int availableQuantity = getAvailableQuantity(productId);
            Purchase purchase = new Purchase();
            User thread1 = new User(purchase, availableQuantity, requestedQuantity);
            thread1.start();
            thread1.join();
            boolean validity = thread1.getValidity();
            if(validity) {
                cartRepository.reserveProduct(userId, productId, requestedQuantity);
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.RESERVE_PRODUCT_SUCCESS_RESPONSE,
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.FAILED_STATUS,
                        Constants.RESERVE_PRODUCT_FAILURE_RESPONSE,
                        Constants.INSUFFICIENT_QUANTITY_ERROR
                );
            }
        }catch(Exception e){
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.RESERVE_PRODUCT_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> unReserveProduct(long userId, long productId) {
        try {
            int quantity = cartRepository.findQuantityFromCart(userId, productId);
            cartRepository.unReserveProduct(userId, productId);
            addQuantityBackToProduct(productId, quantity);
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    Constants.UNRESERVE_PRODUCT_SUCCESS_RESPONSE,
                    Constants.NO_ERROR
            );
        }catch(Exception e){
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.UNRESERVE_PRODUCT_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public void addQuantityBackToProduct(long productId, int quantity) {
        try {
            System.out.println("Quantity of " + quantity + " Added To Product " + productId);
        }catch(Exception e) {

        }
    }

    public int getAvailableQuantity(long id) {
        int availableQuantity = 2;
        try {
            return availableQuantity;
        }catch(Exception e) {
            return 0;
        }
    }
}
