package com.example.server.Shukra.Service.Subcategory;

import java.util.List;

// import com.example.server.Shukra.Model.Category;
import com.example.server.Shukra.Model.Subcategory;

public interface SubcategoryService {

    Subcategory createSubcategory(Subcategory subcategory) throws Exception;

    List<Subcategory> getAllSubcategories() throws Exception;

    List<Subcategory> getSubcategoriesByCategoryId(String categoryId) throws Exception;

    // Subcategory getSubcategoryById(String id);

    // Subcategory updateSubcategory(Subcategory subcategory);

    // void deleteSubcategory(String id);
}
