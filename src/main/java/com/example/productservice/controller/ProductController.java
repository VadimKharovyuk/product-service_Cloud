package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
      return   productService.findById(id).orElseThrow();
      //http://localhost:8080/orders/1/product

    }
    @GetMapping("/products/all")
    public List<Product> getAllProducts() {
        return productService.productList();
        //http://localhost:8080/orders/products/all
    }

@PostMapping("products/save")
    public Product saveProduct(@RequestBody Product product){
       return productService.save(product);
}
}
