package com.walter.simpleWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Product {

    private int prodId;
    private String prodName;
    private int Price;

    public Product() {
    }
}
