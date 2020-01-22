package com.oktay.productservice.controllers;


import dtos.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public ResponseEntity<List<Product>> findProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("1","airpods"));
        products.add(new Product("2","macbook"));
        return ResponseEntity.ok(products);
    }

}
