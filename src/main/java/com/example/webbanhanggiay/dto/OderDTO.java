package com.example.webbanhanggiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OderDTO {

    //oder
    private String recipientName;

    private String address;

    private Integer phone;

    private BigDecimal thanhTien;

    private Integer trangThai;

    //oderDetail

    private Integer idOder;

    private Integer idProduct;

    private Integer quantity;

    private BigDecimal totalMoney;

}
