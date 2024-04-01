package com.example.server.Shukra.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.server.Shukra.Model.PaymentGateway;

@Repository
public interface PaymentGatewayRepository extends MongoRepository<PaymentGateway, String> {

}
