package com.example.server.Shukra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.server.Shukra.Model.Product;
import com.example.server.Shukra.Service.Product.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/addProduct")
    public ResponseEntity<Product> addProduct(
            String productCategories,
            String subcategories,
            String productName,
            String description,
            Number purchasePrice,
            Number mrpPrice,
            Number profit,
            Number productQuantity,
            Number stockQuantity,
            String color,
            Number size,
            @RequestParam("file") MultipartFile[] photos,
            @RequestParam("file") MultipartFile[] productDetailPhotos) {
        Product saveProduct = productService.addProduct(productCategories, subcategories, productName, description,
                purchasePrice,
                mrpPrice, profit, productQuantity, stockQuantity, color, size, photos, productDetailPhotos);
        return ResponseEntity.ok().body(saveProduct);
    }
}
