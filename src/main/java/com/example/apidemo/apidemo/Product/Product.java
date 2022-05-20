package com.example.apidemo.apidemo.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    public Float getDoublePrice(){
        return this.price * 2;
    }
*/
}