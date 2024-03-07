package com.example.server.Shukra.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Subcategory")
public class Subcategory {

    @Id
    private ObjectId id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)

    private String name;

    public Subcategory(String name, ObjectId id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
