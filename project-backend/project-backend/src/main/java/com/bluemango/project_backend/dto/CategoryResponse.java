package com.bluemango.project_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CategoryResponse {
    private Integer id;
    private String name;

    public CategoryResponse(){

    };

    //AAAAHHH agora entendi. Este construtor é como se fosse um construtor normal mas para o response. HAHAHHAHA.
    public CategoryResponse(Integer id, String name) {
        //TODO Auto-generated constructor stub
        this.id = id;
        this.name = name;
    };
    // Getters and Setters
    public Integer getId() {
        return id;
    };
    public void setId(Integer id) {
        this.id = id;
    };
    public String getName() {
        return name;
    };
    public void setName(String name) {
        this.name = name;
    };
    

    
};
