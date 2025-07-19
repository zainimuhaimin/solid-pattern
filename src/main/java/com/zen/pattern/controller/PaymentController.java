package com.zen.pattern.controller;

import com.zen.pattern.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    /**
     * controller ini untuk mengimplementasikan Dependency Inversion Principle (DIP)
     * DIP ini pada dasarnya jika lo punya service yang berskala besar baiknya lu harus bikin interface classnya
     * agar tidak bergantung langsung pada service classnya.
     * <p>
     * nah DIP ini adalah High-level modules should not depend on low-level modules.
     * Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.
     * jadi DIP Modul yang "mengatur logika besar" (high-level) jangan tergantung langsung ke modul detail (low-level).
     * Keduanya harus bergantung ke interface (abstraction).
     * Dan yang detail harus menyesuaikan diri ke interface itu.
     */

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public ResponseEntity<String> doPayment() {
        String result = paymentService.processPayment("trxPayment");
        return ResponseEntity.ok().body(result);
    }
}
