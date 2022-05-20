package com.example.apidemo.apidemo.Product;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.apidemo.apidemo.Response.*;

@RestController
public class ProductController {
    public enum HttpMessage {
        UPDATED("Product updated."),
        LIST("Product List."),
        NOT_FOUND("Product not found."),
        DELETED("Product deleted.");

        private final String description;

        HttpMessage(String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> list() {
        List<Product> productList = service.listAll();
        logger.info(productList.toString());
        return productList;
    }

    @GetMapping("/products/name/{name}")
    public List<Product> findByName(@PathVariable String name) {
        List<Product> productList = service.findByName(name);
        return productList;
    }

    @GetMapping("/products/lastid")
    public ResponseEntity<Product> getLastId() {
        try {
            Product product = service.getLastById();
            logger.info("list: ================= " + product);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        service.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Response> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existProduct = service.get(id);
            HttpStatus httpStatus = HttpStatus.OK;
            HttpMessage httpMessage = HttpMessage.UPDATED;
            service.save(product);
            Response response = new Response(httpStatus, httpMessage.description, product);
            return new ResponseEntity<Response>(response, httpStatus);

        } catch (NoSuchElementException e) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            Response response = new Response(httpStatus, e.toString(), new Product());
            return new ResponseEntity<Response>(response, httpStatus);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id) {
        try {
            Product existProduct = service.get(id);
            HttpStatus httpStatus = HttpStatus.OK;
            HttpMessage httpMessage = HttpMessage.DELETED;
            Response response = new Response(httpStatus, httpMessage.description, existProduct);
            service.delete(id);
            return new ResponseEntity<Response>(response, httpStatus);
        } catch (Exception e) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            Response response = new Response(httpStatus, e.toString(), new Product());
            return new ResponseEntity<Response>(response, httpStatus);
        }
    }

}