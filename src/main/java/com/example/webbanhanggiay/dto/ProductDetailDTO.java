package com.example.webbanhanggiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {

    private String name;

    private Float price;

    private String description;

    private String color;

    private Integer size;

    private String image;

}