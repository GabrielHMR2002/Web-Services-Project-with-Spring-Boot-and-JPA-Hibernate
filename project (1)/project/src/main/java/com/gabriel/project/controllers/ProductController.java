package com.gabriel.project.controllers;

import com.gabriel.project.entities.Product;
import com.gabriel.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll()
;        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    public ResponseEntity<Product> findById(UUID id){
        Product product = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
