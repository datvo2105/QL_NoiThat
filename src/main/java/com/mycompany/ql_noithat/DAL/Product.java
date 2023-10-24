package com.mycompany.ql_noithat.DAL;

public class Product {
    private int productId;
    private String productName;
    private int categoryId;
    private String desc;
    private Double price;

    public Product() {
    }

    public Product(int productId, String productName, int categoryId, String desc, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.desc = desc;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
