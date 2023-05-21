package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.entity.ProductDetail;
import com.oracle.wls.shaded.org.apache.bcel.generic.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {

    @Query("SELECT p.name,cl.name,s.size,c.name,o.name,pd.quantity,pd.price,p.description,i.image From Product p " +
            "JOIN p.listImage i " +
            "JOIN p.listProduct pd " +
            "JOIN pd.category c " +
            "JOIN pd.size s " +
            "JOIN pd.origin o " +
            "JOIN pd.color cl " +
            "WHERE i.id =(SELECT MIN(i2.id) FROM Image i2 WHERE i2.product = p)")
    List<Object[]> selectAllProduct();

}
