package com.walter.simpleWebApp.service;

import com.walter.simpleWebApp.model.Product;
import com.walter.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101,"Iphone",50000),
//            new Product(102,"Camera",70),
//            new Product(103,"Shure Mic",10000)));

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductsById(int prodId) {
        return repo.findById(prodId).orElse(new Product());


    }

    public void addProduct(Product prod){
        repo.save(prod);

    }


    public void updateProduct(Product prod) {
         repo.save(prod);

    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);

    }

}
