package com.gabriel.project.controllers;

import com.gabriel.project.entities.Category;
import com.gabriel.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = categoryService.findaAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Category> findById(@PathVariable UUID id){
        Category obj = categoryService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

}
