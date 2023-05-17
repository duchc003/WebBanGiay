package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findByProductData();

    ProductDTO findByName(String name);

    Page<ProductDTO> getAllProduct(Integer pageNo, Integer pageSize);
}
