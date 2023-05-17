package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.entity.Category;
import com.example.webbanhanggiay.repository.CategoryRepository;
import com.example.webbanhanggiay.repository.ProductRepository;
import com.example.webbanhanggiay.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoryDetailDTO> listProductByCategory(Integer categoryId) {
        List<Object[]> result = productRepository.listProductByCategory(categoryId);
        List<CategoryDetailDTO> categoryDetailDTOList = new ArrayList<>();

        for (Object[] listObjects:result){
            String name = (String) listObjects[0];
            String image = (String) listObjects[1];
            Float price = (Float) listObjects[2];
            CategoryDetailDTO categoryDetailDTO = new CategoryDetailDTO(name,image,price);
            categoryDetailDTOList.add(categoryDetailDTO);
        }
        return categoryDetailDTOList;
    }

    @Override
    public List<Category> getALL() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }
}
