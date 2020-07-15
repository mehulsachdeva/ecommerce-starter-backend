package com.service.eCommerceStarter.services.Commons;

public class Constants {

    public static final String EMAIL_ALREADY_REGISTERED_RESPONSE = "Email Already Exists";
    public static final String EMAIL_REGISTERED_CHECKER_FAILURE_RESPONSE = "Failed To Check If Email Is Already Registered Or Not";
    public static final String EMAIL_NOT_REGISTERED_RESPONSE = "Email Not Registered";

    public static final String REGISTER_USER_SUCCESS_RESPONSE = "User Registered Successfully";
    public static final String REGISTER_USER_FAILURE_RESPONSE = "Failed To Register User";

    public static final String UPDATE_SHIPPING_SUCCESS_RESPONSE = "Shipping Details Updated Successfully";
    public static final String UPDATE_SHIPPING_FAILURE_RESPONSE = "Failed To Update Shipping Details";
    public static final String FETCH_SHIPPING_NO_RECORD_RESPONSE = "No Shipping Details Found";
    public static final String FETCH_SHIPPING_FAILURE_RESPONSE = "Failed To Fetch Shipping Details";

    public static final String MAKE_PURCHASE_SUCCESS_RESPONSE = "Purchase Made Successfully";
    public static final String MAKE_PURCHASE_FAILURE_RESPONSE = "Failed To Make Purchase";
    public static final String OUT_OF_STOCK_RESPONSE = "One Or More Item Became Out of Stock";
    public static final String OUT_OF_STOCK_ERROR = "Out Of Stock Error";

    public static final String FETCH_PURCHASE_HISTORY_FAILURE_RESPONSE = "Failed To Fetch Purchase History";
    public static final String FETCH_PURCHASES_FAILURE_RESPONSE = "Failed To Fetch All Purchases";

    public static final String STORE_PRODUCT_SUCCESS_RESPONSE = "Product Stored Successfully";
    public static final String STORE_PRODUCT_FAILURE_RESPONSE = "Failed To Store Product";

    public static final String UPDATE_PRODUCT_SUCCESS_RESPONSE = "Product Updated Successfully";
    public static final String UPDATE_PRODUCT_FAILURE_RESPONSE = "Failed To Update Product";

    public static final String NO_PRODUCT_FOUND_BY_ID = "No Product Found By Id";

    public static final String FETCH_PRODUCTS_FAILURE_RESPONSE = "Failed To Fetch Products";
    public static final String SUCCESS_STATUS = "Success";
    public static final String FAILED_STATUS = "Failure";
    public static final String NO_ERROR = "";
    public static final String EXCEPTION_RAISED = "Exception Raised: ";

    //SQL Query
    public static final String GET_PRODUCT_VERSION_QUERY = "SELECT version FROM products WHERE product_id = :productId";

    //Variables
    public static final int PAGE_SIZE = 10;
}
