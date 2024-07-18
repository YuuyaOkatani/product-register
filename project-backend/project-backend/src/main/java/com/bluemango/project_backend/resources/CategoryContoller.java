package com.bluemango.project_backend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bluemango.project_backend.dto.CategoryRequest;
import com.bluemango.project_backend.dto.CategoryResponse;
import com.bluemango.project_backend.services.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("categories")
public class CategoryContoller {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    // criar um corpo JSON para postar
    public ResponseEntity<CategoryResponse> save(@Validated @RequestBody CategoryRequest categoryRequest) {

        CategoryResponse category = categoryService.save(categoryRequest);

        // Location -> URI(Endereço)
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/${id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(location).body(category);

    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> getCategories(@PathVariable int id) {
        CategoryResponse cat = categoryService.getById(id);

        return ResponseEntity.ok(cat);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeCategorys(@PathVariable int id) {

        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCategorys(@PathVariable int id, @RequestBody CategoryRequest categoryUpdate) {

        categoryService.update(id, categoryUpdate);

        return ResponseEntity.ok().build();

    }

}
