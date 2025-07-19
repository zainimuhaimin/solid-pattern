package com.zen.pattern.services.impl;

import com.zen.pattern.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String processPayment(String order) {
        return String.format("this is service implement DIP (Dependency Inversion Principle)");
    }
}
