package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.entity.Category;
import com.example.webbanhanggiay.repository.CategoryRepository;
import com.example.webbanhanggiay.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
