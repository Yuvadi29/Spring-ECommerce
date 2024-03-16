package com.example.server.Shukra.Service.Subcategory;

import java.util.List;

import com.example.server.Shukra.Model.Category;
// import com.example.server.Shukra.Model.Category;
import com.example.server.Shukra.Model.Subcategory;

public interface SubcategoryService {
    // Subcategory createSubcategory(String name, String categoryId) throws
    // Exception;
    Subcategory createSubcategory(String name, Category category) throws Exception;

    List<Subcategory> getAllSubcategories() throws Exception;

    // Subcategory getSubcategoryById(String id);

    List<Subcategory> getSubcategoriesByCategoryId(String categoryId) throws Exception;

    // Subcategory updateSubcategory(Subcategory subcategory);

    // void deleteSubcategory(String id);
}
