package com.example.apidemo.apidemo.Product;

import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
@Transactional
public class ProductService {
 
    @Autowired
    private ProductRepository repo;
    
    public List<Product> findLast() {
        //return repo.findBy(example, queryFunction);
        
        return null;
    }

    public List<Product> findByName(String name) {
        //return repo.findBy(example, queryFunction);
        
        return repo.findByName(name);
    }

    public List<Product> listAll() {
        return repo.findAll();
    }
     
    public void save(Product product) {
        repo.save(product);
    }
     
    public Product get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Product getLastById(Integer id) {
        //return repo.findTopByOrderByIdDesc(id);
        return null;
    }
}