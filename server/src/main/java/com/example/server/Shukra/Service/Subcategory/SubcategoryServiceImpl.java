package com.example.server.Shukra.Service.Subcategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.server.Shukra.Model.Subcategory;
import com.example.server.Shukra.Repository.SubcategoryRepository;

@Service
@Transactional
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public Subcategory createSubcategory(Subcategory subcategory) throws Exception {
        try {
            return subcategoryRepository.save(subcategory);
        } catch (Exception e) {
            throw new Exception("Could not add Subcategory");
        }
    }

    @Override
    public List<Subcategory> getAllSubcategories() throws Exception {
        try {
            return this.subcategoryRepository.findAll();
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Could not find Subcategory");
        }
    }

    @Override
    public List<Subcategory> getSubcategoriesByCategoryId(String categoryId) throws Exception {
        try {
            return subcategoryRepository.findByCategory_Id(categoryId);
        } catch (Exception e) {
            throw new Exception("Could not find Subcategories by CategoryId", e);
        }
    }

}
