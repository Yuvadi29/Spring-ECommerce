package com.example.server.Shukra.Service.Product;

import org.springframework.web.multipart.MultipartFile;

import com.example.server.Shukra.Model.Product;

public interface ProductService {
    Product addProduct(String productCategories, String subcategories, String productName, String description,
            Number purchasePrice,
            Number mrpPrice, Number profit, Number productQuantity, Number stockQuantity, String color, Number size,
            MultipartFile[] photos, MultipartFile[] productDetailPhotos);
}
