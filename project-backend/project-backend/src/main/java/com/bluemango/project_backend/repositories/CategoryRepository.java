package com.bluemango.project_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluemango.project_backend.models.Category;


///Economizar linhas SQL
public interface CategoryRepository extends JpaRepository <Category,Integer>{
} 