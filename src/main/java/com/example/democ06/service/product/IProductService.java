package com.example.democ06.service.product;

import com.example.democ06.model.Product;
import com.example.democ06.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findByNameContaining(String name, Pageable pageable);
}
