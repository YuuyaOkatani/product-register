package com.bluemango.project_backend.dto;

public class ProductResponse {

    private Long id;
    private String name; 
    private String desc;
    private double price;
    private CategoryResponse category;  // returns the category id

    private boolean promotion;

    public ProductResponse() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public CategoryResponse getCategory() {
        return category;
    }
    public void setCategory(CategoryResponse category) {
        this.category = category;
    }
    public boolean isPromotion() {
        return promotion;
    }
    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
    public boolean isNovo() {
        return novo;
    }
    public void setNovo(boolean novo) {
        this.novo = novo;
    }
    private boolean novo; 

}
