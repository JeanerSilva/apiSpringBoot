package com.example.apidemo.apidemo.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);
    Product  findTopByOrderByIdDesc();
 
}