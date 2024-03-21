package com.example.server.Shukra.Service.Category;

import java.util.List;

import com.example.server.Shukra.Model.Category;

public interface CategoryService {
    Category addCat(Category category) throws Exception;

    List<Category> getAllCat() throws Exception;

    Category getCategoryById(String id);

    Category updateCat(Category category);

    void deleteCat(String id);

    // Category getCatProd(String id);

}
