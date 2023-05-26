package com.example.webbanhanggiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Integer idCustomer;

    private Float unitPrice;

    private Integer idCart;

    private Integer idProduct;

    private String nameProduct;

    private Integer quantity;

    private Date dateCreate;

    private Date dateFix;
}
