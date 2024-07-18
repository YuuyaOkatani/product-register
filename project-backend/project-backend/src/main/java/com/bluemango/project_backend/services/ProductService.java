package com.bluemango.project_backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bluemango.project_backend.dto.ProductRequest;
import com.bluemango.project_backend.dto.ProductResponse;
import com.bluemango.project_backend.models.Category;
import com.bluemango.project_backend.models.Product;
import com.bluemango.project_backend.repositories.ProductRepository;
import com.bluemango.project_backend.services.exceptions.DatabaseException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        return product.toDTO();

    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(p -> p.toDTO())
                .collect(Collectors.toList());
    }

    public ProductResponse save(ProductRequest productRequest) {
        try {
            Product product = productRepository.save(productRequest.toEntity());
            return product.toDTO();
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Constrain violation, product can't be saved");
        }
    }

    public void deleteById(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Constrain violation, product can't be deleted");

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Product not found");

        }

    }

    public void update(Long id, ProductRequest productRequest) {

        try {

            Product existingProduct = productRepository.getReferenceById(id);

            Category category = new Category(productRequest.getCategory().getId());

            existingProduct.setName(productRequest.getName());
            existingProduct.setPrice(productRequest.getPrice());
            existingProduct.setDesc(productRequest.getDesc());
            existingProduct.setCategory(category); // returns the category
            existingProduct.setPromotion(productRequest.isPromotion());
            existingProduct.setNovo(productRequest.isNovo());
            productRepository.save(existingProduct);

        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Product not found");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Constrain violation, product can't be updated");
        }

    }

}
