package com.service.eCommerceStarter.services.ShippingService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.eCommerceStarter.models.ShippingDetails;
import com.service.eCommerceStarter.services.Commons.Constants;
import com.service.eCommerceStarter.utils.ResponseBuilder.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ShippingServiceImpl {
    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private ResponseBuilder responseBuilder;

    public Map<String, String> updateShippingDetails(ShippingDetails shippingDetails) {
        try {
            shippingRepository.save(shippingDetails);
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    Constants.UPDATE_SHIPPING_SUCCESS_RESPONSE,
                    Constants.NO_ERROR
            );
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.UPDATE_SHIPPING_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> fetchShippingDetails(long userId) {
        try {
            Optional<ShippingDetails> shippingDetailsContainer = shippingRepository.findById(userId);
            if(shippingDetailsContainer.isPresent()) {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        new ObjectMapper().writeValueAsString(shippingDetailsContainer.get()),
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.FETCH_SHIPPING_NO_RECORD_RESPONSE,
                        Constants.NO_ERROR
                );
            }
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.FETCH_SHIPPING_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }
}
