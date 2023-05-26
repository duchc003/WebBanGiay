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
public class DiscountDTO {

    private String maDiscount;

    private String name;

    private Integer HinhThucKhuyenMai;

    private Integer mucGiamGia;

    private Date ngayBatDau;

    private Date ngayKetThuc;
}
