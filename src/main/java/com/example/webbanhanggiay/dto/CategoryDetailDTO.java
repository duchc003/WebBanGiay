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
public class CategoryDetailDTO {

    private String name;

    private String image;

    private BigDecimal price;

}