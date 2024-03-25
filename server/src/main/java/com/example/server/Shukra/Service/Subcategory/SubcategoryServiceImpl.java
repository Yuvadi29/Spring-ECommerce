package com.example.server.Shukra.Service.Subcategory;

import java.util.List;
import java.util.Optional;

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
            throw new Exception("Could not find Subcategory");
        }
    }

    @Override
    public Subcategory getSubcategoryById(String id) {
        Optional<Subcategory> subcategory = this.subcategoryRepository.findById(id);

        if (subcategory.isPresent()) {
            return subcategory.get();
        } else {
            System.out.println("Subcategory not found with id: " + id);
        }
        return null;
    }

    @Override
    public List<Subcategory> getSubcategoriesByCategoryId(String categoryId) throws Exception {
        try {
            return subcategoryRepository.findByCategory_Id(categoryId);
        } catch (Exception e) {
            throw new Exception("Could not find Subcategories by CategoryId", e);
        }
    }

    @Override
    public Subcategory updateSubcategory(Subcategory subcategory) {
        Optional<Subcategory> Subcategory = this.subcategoryRepository.findById(subcategory.getId());

        if (Subcategory.isPresent()) {
            Subcategory updatedSubcategory = Subcategory.get();
            updatedSubcategory.setId(subcategory.getId());
            updatedSubcategory.setName(subcategory.getName());
            subcategoryRepository.save(updatedSubcategory);
            return updatedSubcategory;
        } else {
            System.out.println("Record Not found with id: " + subcategory.getId());
        }
        return subcategory;
    }

    @Override
    public void deleteSubcategory(String id) {
        Optional<Subcategory> Subcategory = this.subcategoryRepository.findById(id);

        if (Subcategory.isPresent()) {
            this.subcategoryRepository.delete(Subcategory.get());
        } else {
            System.out.println("Subcategory Not Found with Id: " + id);
        }
    }

}
