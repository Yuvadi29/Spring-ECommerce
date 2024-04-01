package com.example.server.Shukra.Service.Payment;

import java.util.List;

import com.example.server.Shukra.Model.PaymentGateway;

public interface PaymentService {
    PaymentGateway createConfig(PaymentGateway paymentGateway) throws Exception;

    List<PaymentGateway> showPaymentMethods() throws Exception;

    PaymentGateway updatePaymentStatus(PaymentGateway paymentGateway);

    // PaymentGateway verifyTransaction(PaymentGateway paymentGateway);
}
