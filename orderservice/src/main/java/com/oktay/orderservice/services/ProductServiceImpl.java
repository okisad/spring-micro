package com.oktay.orderservice.services;


import com.oktay.orderservice.client.ProductServiceFeignClient;
import dtos.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductServiceFeignClient productServiceFeignClient;

    public ProductServiceImpl(ProductServiceFeignClient productServiceFeignClient) {
        this.productServiceFeignClient = productServiceFeignClient;
    }


    @Override
    public List<Product> findProducts() {
        return productServiceFeignClient.getProducts();
    }
}
