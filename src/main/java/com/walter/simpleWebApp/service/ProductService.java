package com.walter.simpleWebApp.service;

import com.walter.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
            new Product(101,"Iphone",50000),
            new Product(102,"Camera",70),
            new Product(103,"Shure Mic",10000));

    public List<Product> getProducts(){
        return products;
    }
}
