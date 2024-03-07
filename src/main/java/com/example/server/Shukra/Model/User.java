package com.example.server.Shukra.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

    @Id
    private ObjectId id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)

    private String firstname;
    private String lastname;
    private String username;
    private Number phone;
    private Number altNumber;
    private String email;
    private String password;
    private String role;
    private String status;
    private String address;

    public User(String firstname, String lastname, String username, Number phone, Number altNumber, String email,
            String password, String role, String status, String address, ObjectId id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.phone = phone;
        this.altNumber = altNumber;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
        this.address = address;
        this.id = id;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public Number getPhone() {
        return phone;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }

    public Number getAltNumber() {
        return altNumber;
    }

    public void setAltNumber(Number altNumber) {
        this.altNumber = altNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
