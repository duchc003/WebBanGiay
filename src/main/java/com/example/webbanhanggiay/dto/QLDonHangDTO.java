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
public class QLDonHangDTO {

    private String hoVaTen;

    private Integer phone;

    private Date ngayDatHang;

    private Date ngayGiaoHang;

    private Date ngayNhanHang;

    private BigDecimal totalMoney;

    private Integer status;
}
