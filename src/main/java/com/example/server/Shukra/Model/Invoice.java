package com.example.server.Shukra.Model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Invoice")
public class Invoice {

    @Id
    private ObjectId id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)

    private String invoiceNumber;
    private Date invoiceDate;
    // private Object customer{String name, String email};
    // private Object[] lineItems;
    private Number totalAmount;

    public Invoice(String invoiceNumber, Date invoiceDate, Number totalAmount, ObjectId id) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Number getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Number totalAmount) {
        this.totalAmount = totalAmount;
    }
}
