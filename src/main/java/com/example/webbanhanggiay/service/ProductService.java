package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.dto.ProductDetailDTO;
import com.example.webbanhanggiay.dto.ProductManagerDTO;
import com.example.webbanhanggiay.dto.ProductViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface ProductService {

    List<ProductDTO> findByProductData();

    ProductDTO findByName(String name);

    Page<ProductDTO> getAllProduct(Integer pageNo, Integer pageSize);

    ProductDetailDTO getOneDetailProduct(String name);

    ProductDTO searchByName(String name);

    Page<ProductDTO> getAllByProduct(Integer categoryId,Integer pageNo, Integer pageSize);

    List<ProductDTO> getAllProductByCate(@Param("categoryId") Integer categoryId);

    List<ProductDTO> findByImage(@Param("name") String name);
}
