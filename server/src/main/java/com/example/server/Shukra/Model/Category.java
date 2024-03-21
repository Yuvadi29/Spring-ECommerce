package com.example.server.Shukra.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Category")
public class Category {

    @Id
    private String id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)

    private String categoryName;

    public Category(String categoryName, String id) {
        this.categoryName = categoryName;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
