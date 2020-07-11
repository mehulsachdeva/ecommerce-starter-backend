package com.service.eCommerceStarter.services.RegisterService;

import com.service.eCommerceStarter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
