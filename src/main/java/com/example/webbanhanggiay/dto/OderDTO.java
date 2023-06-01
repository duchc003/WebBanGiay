package com.example.webbanhanggiay.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Vui Lòng Nhập Họ và Tên")
    private String recipientName;

    @NotBlank(message = "Vui lòng Nhập Địa Chỉ")
    private String address;

    @NotBlank(message = "Email is required")
    @Email(message = "Wrong email format")
    private String email;

    @NotNull(message = "Vui Lòng Nhập Số Điện Thoại")
    private Integer phone;

    private BigDecimal thanhTien;

    //oderDetail

    private Integer idOder;

    private Integer idProduct;

    private Integer quantity;

    private BigDecimal totalMoney;

}
