package com.bluemango.project_backend.dto;

import com.bluemango.project_backend.models.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategoryRequest {

    @Size(min = 3, max = 255, message = "Name length min = 3 and max = 255")
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    public String getName() {
        return name;
    };

    public void setName(String name) {
        this.name = name;
    };

    public Category toEntity(){
        return new Category(name);
    };

    
};
