package com.example.democ06.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductForm {
    private Long id;

    @NotEmpty(message = "Không được để trống")
    private String name;

    @NotNull
    private String description;

    private MultipartFile image;

    private double price;

    private Category category;
}
