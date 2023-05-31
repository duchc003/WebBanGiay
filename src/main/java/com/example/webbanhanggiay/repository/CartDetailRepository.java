package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.entity.CartDetail;
import com.example.webbanhanggiay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {

    @Query("Select MIN(i.image),p.name,pd.price,dp.unitPrice,cd.quantity FROM CartDetail cd " +
            "JOIN cd.productDetail pd " +
            "JOIN  pd.product p " +
            "JOIN p.listImage i " +
            "JOIN p.listDiscountProduct dp " +
            "where cd.cart.user = :user GROUP BY p.name,pd.price,dp.unitPrice,cd.quantity")
    List<Object[]> getCartDetail(@Param("user") User user);

    @Query("Select MIN(i.image),p.name,pd.price,SUM(dp.unitPrice),pd.quantity FROM CartDetail cd " +
            "JOIN cd.productDetail pd " +
            "JOIN  pd.product p " +
            "JOIN p.listImage i " +
            "JOIN p.listDiscountProduct dp " +
            "where cd.cart.user = :user GROUP BY p.name,pd.price,dp.unitPrice,pd.quantity")
    List<Object[]> sumPriceInCart(@Param("user") User user);

}
