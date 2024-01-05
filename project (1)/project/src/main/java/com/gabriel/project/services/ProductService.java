package com.gabriel.project.services;

import com.gabriel.project.entities.Product;
import com.gabriel.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

   @Autowired
   private ProductRepository productRepository;

   public List<Product> findAll(){
       return productRepository.findAll();
   }

   public Product findById(UUID id){
       Optional<Product> obj = productRepository.findById(id);
       return obj.get();
   }


}
