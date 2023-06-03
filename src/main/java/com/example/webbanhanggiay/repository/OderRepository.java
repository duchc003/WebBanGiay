package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.entity.Oder;
import com.example.webbanhanggiay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OderRepository extends JpaRepository<Oder,Integer> {

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 1")
    List<Object[]> choThanhToan(User user);

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 2")
    List<Object[]> vanChuyen(User user);

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 3")
    List<Object[]> dangGiao(User user);

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 4")
    List<Object[]> hoanThanh(User user);

    @Query("SELECT p.name,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p WHERE o.user = :user and o.status = 5")
    List<Object[]> daHuy(User user);

    @Query("SELECT o.recipientName,o.phone,o.ngayDatHang,o.ngayGiaoHang,o.ngayNhanHang,o.thanhTien,o.status FROM Oder o " +
            "JOIN o.listOderDetail od " +
            "JOIN od.productDetail pd " +
            "JOIN pd.product p")
    List<Object[]> quanLyDonHang();
}
