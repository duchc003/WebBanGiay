package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.entity.Category;
import com.example.webbanhanggiay.entity.Color;
import com.example.webbanhanggiay.entity.Origin;
import com.example.webbanhanggiay.entity.Size;

import java.util.List;

public interface ProductManagerService {

    List<CategoryDetailDTO> listProductByCategory(Integer categoryId);

    List<Category> getALL();

    List<Origin> getALLOrigin();

    List<Color> getALLColor();

    List<Size> getALLSize();
}
