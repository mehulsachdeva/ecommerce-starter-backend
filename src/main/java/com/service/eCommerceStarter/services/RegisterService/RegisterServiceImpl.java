package com.service.eCommerceStarter.services.RegisterService;

import com.service.eCommerceStarter.models.User;
import com.service.eCommerceStarter.services.Commons.Constants;
import com.service.eCommerceStarter.utils.ResponseBuilder.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class RegisterServiceImpl {
    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private ResponseBuilder responseBuilder;

    public Map<String, String> registerUser(User user) {
        try {
            registerRepository.save(user);
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    Constants.REGISTER_USER_SUCCESS_RESPONSE,
                    Constants.NO_ERROR
            );
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.REGISTER_USER_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> checkEmailIsRegistered(String email) {
        try {
            Optional<User> userContainer = registerRepository.findByEmail(email);
            if(userContainer.isPresent()) {
                return responseBuilder.createResponse(
                        Constants.FAILED_STATUS,
                        Constants.EMAIL_ALREADY_REGISTERED_RESPONSE,
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.EMAIL_NOT_REGISTERED_RESPONSE,
                        Constants.NO_ERROR
                );
            }
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.EMAIL_REGISTERED_CHECKER_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }
}
