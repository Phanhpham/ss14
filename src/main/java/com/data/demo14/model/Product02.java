package com.data.demo14.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product02 {
    private String name;
    private double price;

    public Product02() {}
    public Product02(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
