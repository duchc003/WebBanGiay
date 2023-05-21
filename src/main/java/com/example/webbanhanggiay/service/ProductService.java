package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.dto.ProductDetailDTO;
import com.example.webbanhanggiay.dto.ProductManagerDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findByProductData();

    ProductDTO findByName(String name);

    Page<ProductDTO> getAllProduct(Integer pageNo, Integer pageSize);

    ProductDetailDTO getOneDetailProduct(String name);

    ProductDTO searchByName(String name);

}
