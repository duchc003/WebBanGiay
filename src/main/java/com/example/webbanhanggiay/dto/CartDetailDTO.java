package com.example.webbanhanggiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailDTO {

    private String image;

    private String name;

    private BigDecimal unitPrice;

    private BigDecimal price;

    private Integer quantity;
}
