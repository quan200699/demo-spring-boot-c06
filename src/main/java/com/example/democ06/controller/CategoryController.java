package com.example.democ06.controller;

import com.example.democ06.exception.NotFoundException;
import com.example.democ06.model.Category;
import com.example.democ06.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/{id}")
    public ModelAndView getCategory(@PathVariable Long id) throws NotFoundException {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            throw new NotFoundException();
        }
        return new ModelAndView("index");
    }
}
