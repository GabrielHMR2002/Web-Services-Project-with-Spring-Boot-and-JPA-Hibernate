package com.gabriel.project.services;

import com.gabriel.project.entities.Category;
import com.gabriel.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findaAll() {
        return categoryRepository.findAll();

    }

    public Category findById(UUID id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

}
