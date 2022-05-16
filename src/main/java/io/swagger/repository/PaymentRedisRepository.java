package io.swagger.repository;

import io.swagger.model.PaymentResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRedisRepository extends CrudRepository<PaymentResponse, String> {
}
