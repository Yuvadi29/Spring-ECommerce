package com.example.server.Shukra.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.Shukra.Model.Category;
import com.example.server.Shukra.Model.Subcategory;
import com.example.server.Shukra.Service.Subcategory.SubcategoryService;

@RestController
@RequestMapping("/api/v1")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping("/subcategories/createsubcategories")
    public ResponseEntity<Subcategory> createSubcategory(@RequestBody Category category, @RequestBody String name) {
        try {
            // Subcategory createdSubcategory = subcategoryService.createSubcategory(name, categoryId);
            // return ResponseEntity.ok().body(createdSubcategory);
            Subcategory savedSubcategory = subcategoryService.createSubcategory(name, category);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSubcategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/subcategories")
    public ResponseEntity<List<Subcategory>> getAllSubcategories() throws Exception {
        return ResponseEntity.ok().body(subcategoryService.getAllSubcategories());
    }

    @GetMapping("/subcategories/{categoryId}")
    public ResponseEntity<?> getSubcategoriesByCategoryId(@PathVariable String categoryId) throws Exception {
        List<Subcategory> subcategories = subcategoryService.getSubcategoriesByCategoryId(categoryId);

        if (subcategories == null || subcategories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No subcategories found for the specifed Category");
        }
        return ResponseEntity.ok().body(subcategories);
    }
}
