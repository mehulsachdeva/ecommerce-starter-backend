package com.service.eCommerceStarter.services.ShippingService;

import com.service.eCommerceStarter.models.ShippingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingDetails, Long> {
}
