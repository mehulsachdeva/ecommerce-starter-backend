package com.service.eCommerceStarter.utils.JwtSecurity.security;

public class Constants {
    public static final String SECRET_KEY = "APPName123$";
    public static final String INCORRECT_JWT_TOKEN = "JWT Token Is Incorrect";
    public static final String MISSING_JWT_TOKEN = "JWT Token Is Missing";
    public static final String AUTHENTICATION_SUCCESS = "Successfully Authentication";
    public static final String GENERATION_JWT_TOKEN_FAILURE_RESPONSE = "JWT Token Generation Failed";
    public static final long JWT_TOKEN_EXPIRATION = 1000 * 60 * 60 * 5;
    public static final String SUCCESS_STATUS = "Success";
    public static final String FAILURE_STATUS = "Failure";
    public static final String NO_ERROR = "";
    public static final String EMPTY_JWT_GENERATED = "";
    public static final String EXCEPTION_RAISED = "Exception Raised: ";
    public static final String INVALID_CREDENTIALS_FOR_JWT_ERROR = "Invalid Credentials";
}
