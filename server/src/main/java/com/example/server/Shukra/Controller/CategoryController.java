package com.example.server.Shukra.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.Shukra.Model.Category;
import com.example.server.Shukra.Service.Category.CategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category/addCat")
    public ResponseEntity<Category> addCat(@RequestBody Category category) throws Exception {
        return ResponseEntity.ok().body(this.categoryService.addCat(category));
    }

    @GetMapping("/category/getAllCat")
    public ResponseEntity<List<Category>> getAllCat() throws Exception {
        return ResponseEntity.ok().body(categoryService.getAllCat());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String id) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @PutMapping("/category/updateCat/{id}")
    public ResponseEntity<Category> updateCat(@PathVariable String id, @RequestBody Category category) {
        category.setId(id);
        return ResponseEntity.ok().body(this.categoryService.updateCat(category));
    }

    @DeleteMapping("/category/deleteCat/{id}")
    public HttpStatus deleteCat(@PathVariable String id){
        this.categoryService.deleteCat(id);
        return HttpStatus.OK;
        // return ResponseEntity.ok().body(this.categoryService.deleteCat(category);)
    }

}
