package com.bluemango.project_backend.dto;

import jakarta.validation.constraints.Min;

public class IntegerDTO {

    @Min(value = 1, message = "Min value 1")
    private Integer id;

    public IntegerDTO() {
    }

    public IntegerDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
}
