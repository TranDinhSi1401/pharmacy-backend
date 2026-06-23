package com.iuh.pharmacy_project.controller;

import com.iuh.pharmacy_project.entity.Product;
import com.iuh.pharmacy_project.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {

        return productService.getProductById(id);
    }
}
