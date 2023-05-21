package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.dto.ProductDetailDTO;
import com.example.webbanhanggiay.dto.ProductManagerDTO;
import com.example.webbanhanggiay.entity.*;

import java.util.List;

public interface ProductManagerService {

    List<CategoryDetailDTO> listProductByCategory(Integer categoryId);

    List<Category> getALL();

    List<Origin> getALLOrigin();

    List<Color> getALLColor();

    List<Size> getALLSize();

    ProductManagerDTO save(ProductManagerDTO productManagerDTO, Image image, ProductDetail productDetail);

    List<ProductManagerDTO> selectAllProduct();

    Integer countProduct();

}
