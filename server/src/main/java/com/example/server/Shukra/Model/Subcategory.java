package com.example.server.Shukra.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "Subcategory")
public class Subcategory {

    @Id
    private String id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)

    @DocumentReference(collection = "Category")
    private Category category;

    private String name;

    public Subcategory(Category category, String name, String id) {
        this.category = category;
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
