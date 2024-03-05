package com.example.server.Shukra.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {

    @Id
    private ObjectId id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)

    private String productCategories;
    private String subcategories;
    private String productName;
    private String description;
    private Number purchasePrice;
    private Number mrpPrice;
    private Number profit;
    private Number productQuantity;
    private Number stockQuantity;
    private String color;
    private Number size;
    private String photos;
    private String productDetailPhoto;

    public Product(
            String productCategories, String subcategories,
            String productName,
            String description,
            Number purchasePrice,
            Number mrpPrice,
            Number profit,
            Number productQuantity,
            Number stockQuantity,
            String color,
            Number size,
            String photos,
            String productDetailPhoto, ObjectId id) {
        this.productCategories = productCategories;
        this.subcategories = subcategories;
        this.productName = productName;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.mrpPrice = mrpPrice;
        this.profit = profit;
        this.productQuantity = productQuantity;
        this.stockQuantity = stockQuantity;
        this.color = color;
        this.size = size;
        this.photos = photos;
        this.productDetailPhoto = productDetailPhoto;
        this.id = id;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(String productCategories) {
        this.productCategories = productCategories;
    }

    public String getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(String subcategories) {
        this.subcategories = subcategories;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Number getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Number purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public 
}
