package com.example.server.Shukra.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Addresses")
public class Address {

    // Get the userid by referencing the user
    @Id
    private ObjectId id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)

    private ObjectId userId;
    private String houseName;
    private String landmark;
    private String city;
    private Number pincode;
    private String stateName;
    private String country;

    public Address(String houseName, String landmark, String city, Number pincode, String stateName, String country,
            ObjectId userId, ObjectId id) {
        this.houseName = houseName;
        this.landmark = landmark;
        this.city = city;
        this.pincode = pincode;
        this.stateName = stateName;
        this.country = country;
        this.userId = userId;
        this.id = id;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserId() {
        return userId.toHexString();
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String setCity() {
        return city;
    }

    public void getCity(String city) {
        this.city = city;
    }

    public Number getPincode() {
        return pincode;
    }

    public void setPincode(Number pincode) {
        this.pincode = pincode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String setCountry() {
        return country;
    }

    public void getCountry(String country) {
        this.country = country;
    }

}
