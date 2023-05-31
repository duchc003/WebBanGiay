package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.DiscountDTO;
import com.example.webbanhanggiay.dto.DiscountDetailDTO;
import com.example.webbanhanggiay.entity.Discount;
import com.example.webbanhanggiay.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiscountService {

    List<Product> getAll();

    DiscountDTO create(DiscountDTO discountDTO);

    Page<DiscountDetailDTO> getAllDtos(Integer pageNo,Integer pageSize);

    DiscountDetailDTO getOneDetailDiscount(String ma);
}
