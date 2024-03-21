package com.example.server.Shukra.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Payment")
public class PaymentGateway {

    @Id
    private ObjectId id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)

    private String paymentGatewayName;
    private String keyName;
    private String secretKey;
    private Boolean active;

    public PaymentGateway(String paymentGatewayName, String keyName, String secretKey, Boolean active, ObjectId id) {
        this.paymentGatewayName = paymentGatewayName;
        this.keyName = keyName;
        this.secretKey = secretKey;
        this.active = active;
        this.id = id;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getPaymentGatewayName() {
        return paymentGatewayName;
    }

    public void setPaymentGatewayName(String paymentGatewayName) {
        this.paymentGatewayName = paymentGatewayName;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
