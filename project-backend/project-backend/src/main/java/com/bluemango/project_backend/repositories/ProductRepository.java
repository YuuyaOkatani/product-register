package com.bluemango.project_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluemango.project_backend.models.Product;

public interface ProductRepository extends JpaRepository <Product,Long>{
}