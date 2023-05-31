package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.entity.DiscountProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountProductRepository extends JpaRepository<DiscountProduct,Integer> {
}
