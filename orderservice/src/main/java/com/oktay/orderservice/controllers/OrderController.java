package com.oktay.orderservice.controllers;


import com.oktay.orderservice.services.ProductService;
import dtos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ProductService productService;

    @Value("${server.port}")
    private int port;

    @GetMapping
    public ResponseEntity<List<Product>> findOrder(){
        System.out.println(String.valueOf(port));
        return ResponseEntity.ok(productService.findProducts());
        //return restTemplate.exchange("http://product-service/product", HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>() {});
    }

}
