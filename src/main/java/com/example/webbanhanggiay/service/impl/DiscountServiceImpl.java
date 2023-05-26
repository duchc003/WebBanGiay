package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.DiscountDTO;
import com.example.webbanhanggiay.entity.Discount;
import com.example.webbanhanggiay.entity.Product;
import com.example.webbanhanggiay.repository.ProductRepository;
import com.example.webbanhanggiay.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> getAll = productRepository.findAll();
        return getAll;
    }

    @Override
    public DiscountDTO create(DiscountDTO discountDTO) {
        Discount discount
        return null;
    }
}
