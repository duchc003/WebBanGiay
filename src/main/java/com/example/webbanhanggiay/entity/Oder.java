package com.example.webbanhanggiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Oder")
public class Oder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_user",referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Id_staff",referencedColumnName = "ID")
    private Staff staff;

    @Column(name = "address")
    private String address;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "ngay_dat_hang")
    private Date ngayDatHang;

    @Column(name = "ngay_giao_hang")
    private Date ngayGiaoHang;

    @Column(name = "ngay_nhan_hang")
    private Date ngayNhanHang;

    @Column(name = "thanh_tien")
    private BigDecimal thanhTien;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "oder",fetch = FetchType.LAZY)
    private List<OderDetail> listOderDetail;
}
