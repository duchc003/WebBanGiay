package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDetailDTO> listProductByCategory(Integer categoryId);

    List<Category> getALL();
}
