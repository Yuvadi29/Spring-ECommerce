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
    private String[] photos;
    private String[] productDetailPhotos;

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
            String[] photos,
            String[] productDetailPhotos, ObjectId id) {
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
        this.productDetailPhotos = productDetailPhotos;
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

    public Number getMrpPrice() {
        return mrpPrice;
    }

    public void setMrPrice(Number mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public Number getProfit() {
        return profit;
    }

    public void setProfit(Number profit) {
        this.profit = profit;
    }

    public Number getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Number productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Number getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Number stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Number getSize() {
        return size;
    }

    public void setSize(Number size) {
        this.size = size;
    }

    public String[] getPhotos() {
        return photos;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    public String[] getProductDetailPhotos() {
        return productDetailPhotos;
    }

    public void setProductDetailPhotos(String[] productDetailPhotos) {
        this.productDetailPhotos = productDetailPhotos;
    }

}
