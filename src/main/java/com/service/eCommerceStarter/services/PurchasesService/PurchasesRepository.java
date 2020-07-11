package com.service.eCommerceStarter.services.PurchasesService;

import com.service.eCommerceStarter.models.Purchases;
import com.service.eCommerceStarter.services.Commons.Constants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases, Long> {
}
