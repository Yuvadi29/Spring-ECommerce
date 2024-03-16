package com.example.server.Shukra.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.server.Shukra.Model.Subcategory;

public interface SubcategoryRepository extends MongoRepository<Subcategory, String> {
    List<Subcategory> findByCategoryId(String categoryId);
}
