package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.entity.CartDetail;
import com.example.webbanhanggiay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {

    @Query("Select pd.id,cd.id, MIN(i.image),p.name,pd.price,cd.quantity,s.size FROM CartDetail cd " +
            "JOIN cd.productDetail pd " +
            "JOIN  pd.product p " +
            "JOIN  pd.size s " +
            "JOIN p.listImage i " +
            "where cd.cart.user = :user GROUP BY pd.id,cd.id,p.name,pd.price,cd.quantity,s.size")
    List<Object[]> getCartDetail(@Param("user") User user);

}
