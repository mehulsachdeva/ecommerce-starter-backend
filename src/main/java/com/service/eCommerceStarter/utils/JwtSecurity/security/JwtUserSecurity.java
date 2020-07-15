package com.service.eCommerceStarter.utils.JwtSecurity.security;

import com.service.eCommerceStarter.models.Purchases;
import com.service.eCommerceStarter.models.ShippingDetails;
import com.service.eCommerceStarter.utils.JwtSecurity.models.JwtUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtUserSecurity {
    public boolean hasAccess(long userId, Authentication authentication) {
        long jwtUserId = ((JwtUserDetails)authentication.getPrincipal()).getUserId();
        if(Long.valueOf(userId) == jwtUserId)
            return true;
        return false;
    }

    public boolean hasAccess(ShippingDetails shippingDetails, Authentication authentication) {
        long jwtUserId = ((JwtUserDetails)authentication.getPrincipal()).getUserId();
        if(shippingDetails.getUserId() == jwtUserId)
            return true;
        return false;
    }

    public boolean hasAccess(Purchases purchases, Authentication authentication) {
        long jwtUserId = ((JwtUserDetails)authentication.getPrincipal()).getUserId();
        if(purchases.getUserId() == jwtUserId)
            return true;
        return false;
    }
}
