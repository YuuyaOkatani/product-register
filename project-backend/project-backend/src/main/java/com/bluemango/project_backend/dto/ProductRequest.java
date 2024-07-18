package com.bluemango.project_backend.dto;


import com.bluemango.project_backend.models.Category;
import com.bluemango.project_backend.models.Product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @Size(min = 3, max = 255, message = "Name length min = 3 and max = 255")
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    private String name; 

    @NotBlank(message = "Description cannot be blank")
    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 3, max = 1024, message = "Description length min = 3 and max = 1024")
    private String desc;

    private double price;

    @NotNull
    @Valid
    private IntegerDTO category;  // returns the category id

    private boolean promotion;

    public ProductRequest(){
        
    }

    public Product toEntity() {
        // TODO Auto-generated method stub
        Product product = new Product();
        product.setName(name);
        product.setDesc(desc);
        product.setPrice(price);
        product.setCategory(new Category(category.getId()));
        product.setPromotion(promotion);
        product.setNovo(novo);

        return product;

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
    public IntegerDTO getCategory() {
        return category;
    }
    public void setCategory(IntegerDTO category) {
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
