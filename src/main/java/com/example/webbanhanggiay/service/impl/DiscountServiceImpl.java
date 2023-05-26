package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.DiscountDTO;
import com.example.webbanhanggiay.entity.Discount;
import com.example.webbanhanggiay.entity.Product;
import com.example.webbanhanggiay.repository.DiscountRepository;
import com.example.webbanhanggiay.repository.ProductRepository;
import com.example.webbanhanggiay.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Product> getAll() {
        List<Product> getAll = productRepository.findAll();
        return getAll;
    }

    @Override
    public DiscountDTO create(DiscountDTO discountDTO, Discount discount) {
        discount.setMa(discountDTO.getMaDiscount());
        discount.setName(discountDTO.getName());
        discount.setDiscountType(discountDTO.getHinhThucKhuyenMai());
        if (discountDTO.getMucGiamGia() == 1){
            discount.setPercentageDiscount(discountDTO.getMucGiamGia());
        }else {
            discount.setCashDiscount(discountDTO.getMucGiamGia());
        }
        discount.setStartDate(discountDTO.getNgayBatDau());
        discount.setEndDate(discountDTO.getNgayKetThuc());
        discount.setStatus(discountDTO.getTrangThai());
        discount = discountRepository.save(discount);
        return discountDTO;
    }
}
