package com.example.apidemo.apidemo.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
 
@Entity
public class Product {
    @Setter private Integer id;
    @Getter @Setter private String name;
    @Getter @Setter private float price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    /*
    public void setId(Integer id) {
        this.id = id;
    }
 

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
 
*/
}