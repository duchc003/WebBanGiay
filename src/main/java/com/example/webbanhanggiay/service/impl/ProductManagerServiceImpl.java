package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.entity.Category;
import com.example.webbanhanggiay.entity.Color;
import com.example.webbanhanggiay.entity.Origin;
import com.example.webbanhanggiay.entity.Size;
import com.example.webbanhanggiay.repository.*;
import com.example.webbanhanggiay.service.ProductManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManagerServiceImpl implements ProductManagerService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OriginRepository originRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeRepository sizeRepository;

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

    @Override
    public List<Origin> getALLOrigin() {
        List<Origin> getALLOrigin = originRepository.findAll();
        return getALLOrigin;
    }

    @Override
    public List<Color> getALLColor() {
        List<Color> getALLOrigin = colorRepository.findAll();
        return getALLOrigin;
    }

    @Override
    public List<Size> getALLSize() {
        List<Size> getALLSize = sizeRepository.findAll();
        return getALLSize;
    }
}
