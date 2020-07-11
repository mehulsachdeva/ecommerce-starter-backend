package com.service.eCommerceStarter.services.CartService;

import com.service.eCommerceStarter.models.Cart;
import com.service.eCommerceStarter.services.Commons.Constants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Transactional
    @Modifying
    @Query(value = Constants.ADD_TO_CART_QUERY, nativeQuery = true)
    void reserveProduct(@Param("userId") long userId, @Param("productId") long productId, @Param("quantity") int quantity);

    @Query(value = Constants.FIND_QUANTITY_FROM_CART_QUERY, nativeQuery = true)
    int findQuantityFromCart(@Param("userId") long userId, @Param("productId") long productId);

    @Transactional
    @Modifying
    @Query(value = Constants.REMOVE_FROM_CART_QUERY, nativeQuery = true)
    void unReserveProduct(@Param("userId") long userId, @Param("productId") long productId);
}
