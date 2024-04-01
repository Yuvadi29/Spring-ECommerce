package com.example.server.Shukra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.Shukra.Model.PaymentGateway;
import com.example.server.Shukra.Service.Payment.PaymentService;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/paymentmethod/paymentconfig")
    public ResponseEntity<PaymentGateway> createConfig(@RequestBody PaymentGateway paymentGateway) throws Exception {
        return ResponseEntity.ok().body(this.paymentService.createConfig(paymentGateway));
    }

    @GetMapping("/paymentmethod/paymentoptions")
    public ResponseEntity<List<PaymentGateway>> paymentoptions() throws Exception{
        return ResponseEntity.ok().body(paymentService.showPaymentMethods());
    }

    // @PostMapping("/paymentmethod/updatestatus")
    // public ResponseEntity
}
