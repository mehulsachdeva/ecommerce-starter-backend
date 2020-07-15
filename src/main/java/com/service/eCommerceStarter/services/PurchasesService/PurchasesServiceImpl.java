package com.service.eCommerceStarter.services.PurchasesService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.eCommerceStarter.models.Product;
import com.service.eCommerceStarter.models.Purchases;
import com.service.eCommerceStarter.services.Commons.Constants;

import com.service.eCommerceStarter.services.ProductService.ProductRepository;
import com.service.eCommerceStarter.utils.ResponseBuilder.ResponseBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PurchasesServiceImpl {
    @Autowired
    private PurchasesRepository purchasesRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ResponseBuilder responseBuilder;

    public Map<String, String> makePurchase(Purchases purchases) {
        try {
            boolean status = true;
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(purchases.getProducts());
            for(int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                long productId = Long.parseLong(jsonObject.get("productId").toString());
                long version = Long.parseLong(jsonObject.get("version").toString());
                if(version != getProductVersion(productId)) {
                    status = false;
                    break;
                }
            }
            if(status) {
                String purchaseProducts = "[";
                for(int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                    long productId = Long.parseLong(jsonObject.get("productId").toString());
                    String name = jsonObject.get("name").toString();
                    String description = jsonObject.get("description").toString();
                    int price = Integer.parseInt(jsonObject.get("price").toString());
                    int isAvailable = Integer.parseInt(jsonObject.get("isAvailable").toString());
                    long version = Long.parseLong(jsonObject.get("version").toString());
                    Product product = new Product(productId, name, description, price, isAvailable, version);
                    product.setIsAvailable(0);
                    purchaseProducts += "{\"productId\":" + productId + ",\"name\":\"" + name + "\"},";
                    productRepository.save(product);
                }
                purchaseProducts = purchaseProducts.substring(0, purchaseProducts.length() - 1);
                purchaseProducts += "]";
                purchases.setProducts(purchaseProducts);
                purchasesRepository.save(purchases);
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.MAKE_PURCHASE_SUCCESS_RESPONSE,
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.FAILED_STATUS,
                        Constants.OUT_OF_STOCK_RESPONSE,
                        Constants.OUT_OF_STOCK_ERROR
                );
            }
        }catch(ObjectOptimisticLockingFailureException e){
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.OUT_OF_STOCK_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.MAKE_PURCHASE_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public long getProductVersion(long productId) {
        try {
            long version = purchasesRepository.getProductVersion(productId);
            return version;
        }catch(Exception e){
            return -1;
        }
    }

    public Map<String, String> fetchPurchaseHistoryById(long userId) {
        try {
            List<Purchases> purchaseHistory = purchasesRepository.findAllByUserId(userId);
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    new ObjectMapper().writeValueAsString(purchaseHistory),
                    Constants.NO_ERROR
            );
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.FETCH_PURCHASE_HISTORY_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> fetchAllPurchases() {
        try {
            List<Purchases> purchases = purchasesRepository.findAll();
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    new ObjectMapper().writeValueAsString(purchases),
                    Constants.NO_ERROR
            );
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.FETCH_PURCHASES_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }
}