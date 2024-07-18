package com.bluemango.project_backend.models;

import java.io.Serializable;

import com.bluemango.project_backend.dto.ProductResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "TBL_PRODUCT")
public class Product implements Serializable {
    
    //Atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 255)
    private String name; 

    @Column(nullable = false, length = 1024)
    private String desc;

    @Min(value = 0 , message = "Price must be greater than 0")
    private Double price;

    @ManyToOne
    private Category category; 

    private boolean promotion;
    private boolean novo; 

    // Constructor

    public Product(){

    }

    
    

    public Product(Long id, String name, String desc, double price, Category category, boolean promotion, boolean novo) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.category = category;
        this.promotion = promotion; 
        this.novo = novo;
    }

    public ProductResponse toDTO() {
        // TODO Auto-generated method stub
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(id);
        productResponse.setName(name);
        productResponse.setDesc(desc); 
        productResponse.setPrice(price);
        productResponse.setCategory(category.toDTO());
        productResponse.setPromotion(promotion);
        productResponse.setNovo(novo);
        return productResponse;
       
        
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + ", promotion="
                + promotion + ", novo=" + novo + "]";
    }

    

    


    



    // Getters and Setters
    
    
    
}
