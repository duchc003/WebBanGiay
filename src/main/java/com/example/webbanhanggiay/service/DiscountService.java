package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.DiscountDTO;
import com.example.webbanhanggiay.entity.Product;

import java.util.List;

public interface DiscountService {

    List<Product> getAll();

    DiscountDTO create(DiscountDTO discountDTO);
}
