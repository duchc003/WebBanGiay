package com.example.webbanhanggiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<ProductDetail> listProduct;
}
