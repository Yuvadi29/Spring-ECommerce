package com.example.server.Shukra.Service.Category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.server.Shukra.Model.Category;
import com.example.server.Shukra.Repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCat(Category category) throws Exception {
        try {
            return this.categoryRepository.save(category);
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Could not add category");
        }
    }

    @Override
    public List<Category> getAllCat() throws Exception {
        try {
            return this.categoryRepository.findAll();
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Could not find category");

        }
    }

    @Override
    public Category getCategoryById(String id) {
        Optional<Category> category = this.categoryRepository.findById(id);

        if (category.isPresent()) {
            return category.get();
        } else {
            System.out.println("Category not found with id: " + id);
        }
        return null;
    }

    @Override
    public Category updateCat(Category category) {
        Optional<Category> Category = this.categoryRepository.findById(category.getId());

        if (Category.isPresent()) {
            Category updatedCat = Category.get();
            updatedCat.setId(category.getId());
            updatedCat.setCategoryName(category.getCategoryName());
            categoryRepository.save(updatedCat);
            return updatedCat;
        } else {
            System.out.println("Record Not found with id: " + category.getId());
        }
        return category;
    }

    @Override
    public void deleteCat(String id) {
        Optional<Category> Category = this.categoryRepository.findById(id);

        if (Category.isPresent()) {
            this.categoryRepository.delete(Category.get());
        } else {
            System.out.println("Category Not Found with Id: " + id);
        }
    }

}
