package com.example.server.Shukra.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.server.Shukra.Model.Product;

public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    // Optional<Product> getProduct(String id);
}
