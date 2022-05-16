package io.swagger.service;

import io.swagger.model.PaymentResponse;
import io.swagger.repository.PaymentRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentRedisService {
    private final PaymentRedisRepository redisRepository;

    @Autowired
    public PaymentRedisService(PaymentRedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    @Cacheable(value = "PaymentResponse", unless="#result == null")
    public Optional<PaymentResponse> findById(String paymentUniqueKey) {
        System.out.println("vide ache");
        return this.redisRepository.findById(paymentUniqueKey);
    }

    public void save(PaymentResponse paymentResponse) {
        this.redisRepository.save(paymentResponse);
    }
}
