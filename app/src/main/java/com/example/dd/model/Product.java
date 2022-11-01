package com.example.dd.model;

public class Product {

    String ProductName;
    String Description;
    String ProductPrice;
    String Supplier;
    String Status;
    String image;

    public Product() {
    }

    public Product(String productName, String description, String productPrice, String supplier, String status, String image) {
        ProductName = productName;
        Description = description;
        ProductPrice = productPrice;
        Supplier = supplier;
        Status = status;
        this.image = image;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
