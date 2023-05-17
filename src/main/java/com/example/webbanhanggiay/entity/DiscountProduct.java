package com.example.webbanhanggiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DiscountProduct")
public class DiscountProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_product",referencedColumnName = "ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Id_discount",referencedColumnName = "ID")
    private Discount discount;

    @Column(name = "unit_price")
    private Float unitPrice;

    @Column(name = "so_tien_con_lai")
    private Float soTienConLai;

    @Column(name = "status")
    private String status;
}
