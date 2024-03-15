package com.example.server.Shukra.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.server.Shukra.Model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, ObjectId> {

    Optional<Category> findById(String id);
}
