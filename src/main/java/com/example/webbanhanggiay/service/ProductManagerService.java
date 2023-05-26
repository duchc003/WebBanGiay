package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.dto.ProductViewDTO;
import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.dto.ProductManagerDTO;
import com.example.webbanhanggiay.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductManagerService {

    ProductManagerDTO add(ProductManagerDTO productManagerDTO, Image image, ProductDetail productDetail);

    Page<ProductViewDTO> selectAllProduct(Integer pageNo, Integer pageSize);

    Integer countProduct();

    void update(ProductManagerDTO productManagerDTO);

    ProductViewDTO selectAllProduct(Integer id);

    List<ProductViewDTO> findByProduct(@Param("name") String name);

    boolean delete(Integer id);

}
