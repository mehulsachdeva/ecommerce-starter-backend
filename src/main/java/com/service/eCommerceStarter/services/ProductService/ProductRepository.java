package com.service.eCommerceStarter.services.ProductService;

import com.service.eCommerceStarter.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingAndPriceBetween(String name, int min, int max, Pageable pageable);
}
