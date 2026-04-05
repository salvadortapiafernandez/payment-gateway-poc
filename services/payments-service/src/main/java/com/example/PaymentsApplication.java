package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.Map;

@SpringBootApplication
public class PaymentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentsApplication.class, args);
    }
}

@RestController
@RequestMapping("/payments")
class PaymentController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping
    public Map<String, String> processPayment(@RequestBody PaymentRequest request) {
        mongoTemplate.save(request, "payments");
        return Map.of("status", "approved", "transactionId", java.util.UUID.randomUUID().toString());
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "up");
    }
}

record PaymentRequest(String orderId, double amount, String currency) {}