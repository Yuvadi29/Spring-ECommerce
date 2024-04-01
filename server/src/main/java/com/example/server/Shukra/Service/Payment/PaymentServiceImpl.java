package com.example.server.Shukra.Service.Payment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.server.Shukra.Model.PaymentGateway;
import com.example.server.Shukra.Repository.PaymentGatewayRepository;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentGatewayRepository paymentGatewayRepository;

    @Override
    public PaymentGateway createConfig(PaymentGateway paymentGateway) throws Exception {
        try {
            return this.paymentGatewayRepository.save(paymentGateway);
        } catch (Exception e) {
            throw new Exception("Could not create payment configuration");
        }
    }

    @Override
    public List<PaymentGateway> showPaymentMethods() throws Exception {
        try {
            return this.paymentGatewayRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Could not find Payment Methods");
        }
    }

    @Override
    public PaymentGateway updatePaymentStatus(PaymentGateway paymentGateway) throws Exception {
        if (paymentGateway == null || paymentGateway.isEmpty()) {
            throw new Exception("Payment gateway name is required");
        }

        Optional<PaymentGateway> PaymentGateway = this.paymentGatewayRepository.findById(paymentGateway.getId());

        if (PaymentGateway.isPresent()) {
            PaymentGateway updatedPayment = PaymentGateway.get();
            updatedPayment.setId(paymentGateway.getId());
            updatedPayment.setPaymentGatewayName(paymentGateway.getPaymentGatewayName());
            updatedPayment.setActive(true);
            paymentGatewayRepository.save(updatedPayment);
            return updatedPayment;
        } else {
            System.out.println("Record Not found with id: " + paymentGateway.getId());
        }
        return paymentGateway;
    }

}
