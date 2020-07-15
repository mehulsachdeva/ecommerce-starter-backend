package com.service.eCommerceStarter.services.PurchasesService;

import com.service.eCommerceStarter.models.Purchases;
import com.service.eCommerceStarter.services.Commons.Constants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases, Long> {

    @Query(value = Constants.GET_PRODUCT_VERSION_QUERY, nativeQuery = true)
    long getProductVersion(@Param("productId") long productId);

    List<Purchases> findAllByUserId(long userId);
}
