package com.bluemango.project_backend.models;

import com.bluemango.project_backend.dto.CategoryResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_CATEGORY") // Coloca o nome na tabela
public class Category {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name; 

    // Constructor
    public Category() {

    }

    public Category(Integer id) {
        //TODO Auto-generated constructor stub
        this.id = id;
    }

    public Category(String name) {
        //TODO Auto-generated constructor stub
        this.name = name;
    }


    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }



    public CategoryResponse toDTO(){
        return new CategoryResponse(id, name);
    }
    

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Category other = (Category) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }

    // Getters and Setters
    
    

}
