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

    public static final String RESERVE_PRODUCT_SUCCESS_RESPONSE = "Reservation Successfully";
    public static final String RESERVE_PRODUCT_FAILURE_RESPONSE = "Failed To Reserve Product";

    public static final String UNRESERVE_PRODUCT_SUCCESS_RESPONSE = "Unreservation Successfully";
    public static final String UNRESERVE_PRODUCT_FAILURE_RESPONSE = "Failed To Unreserve Product";

    public static final String INSUFFICIENT_QUANTITY_ERROR = "Insufficient Product Quantity";

    public static final String SUCCESS_STATUS = "Success";
    public static final String FAILED_STATUS = "Failure";
    public static final String NO_ERROR = "";
    public static final String EXCEPTION_RAISED = "Exception Raised: ";

    //SQL Query
    public static final String ADD_TO_CART_QUERY = "INSERT INTO cart (user_id, product_id, quantity) VALUES (:userId, :productId, :quantity)";
    public static final String FIND_QUANTITY_FROM_CART_QUERY = "SELECT quantity FROM cart WHERE user_id = :userId AND product_id = :productId";
    public static final String REMOVE_FROM_CART_QUERY = "DELETE FROM cart WHERE user_id = :userId AND product_id = :productId";
}
