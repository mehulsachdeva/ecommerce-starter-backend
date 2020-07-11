package com.service.eCommerceStarter.services.PurchasesService;

import com.service.eCommerceStarter.models.Purchases;
import com.service.eCommerceStarter.services.Commons.Constants;
import com.service.eCommerceStarter.utils.Classes.Purchase;

import com.service.eCommerceStarter.utils.Classes.User;
import com.service.eCommerceStarter.utils.ResponseBuilder.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PurchasesServiceImpl {
    @Autowired
    private PurchasesRepository purchasesRepository;

    @Autowired
    private ResponseBuilder responseBuilder;

    public Map<String, String> makePurchase(Purchases purchases) {
        try {
            purchasesRepository.save(purchases);
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    Constants.MAKE_PURCHASE_SUCCESS_RESPONSE,
                    Constants.NO_ERROR
            );
        } catch (Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.MAKE_PURCHASE_FAILURE_RESPONSE,
                    Constants.NO_ERROR
            );
        }
    }
}