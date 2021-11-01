package com.example.democ06.controller;

import com.example.democ06.model.Category;
import com.example.democ06.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@Validated @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }
}
