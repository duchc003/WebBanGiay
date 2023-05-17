package com.example.webbanhanggiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "percentage_discount")
    private Integer percentageDiscount;

    @Column(name = "cash_discount")
    private Integer cashDiscount;

    @Column(name = "dtatus")
    private String status;

    @Column(name = "discount_type")
    private String discountType;

    @OneToMany(mappedBy = "discount",fetch = FetchType.LAZY)
    private List<DiscountProduct> listDiscountProduct;
}
