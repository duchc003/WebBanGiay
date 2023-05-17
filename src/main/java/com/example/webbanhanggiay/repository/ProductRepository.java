package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p.name, i.image, pd.price " +
            "FROM Product p " +
            "INNER JOIN p.listImage i " +
            "INNER JOIN p.listProduct pd"
    )
    List<Object[]> findAllProductDetails();

    @Query("SELECT p.name, i.image, pd.price " +
            "FROM Product p " +
            "JOIN p.listImage i " +
            "JOIN p.listProduct pd " +
            "WHERE pd.category.id = :categoryId")
    List<Object[]> listProductByCategory(@Param("categoryId") Integer categoryId);

    Product findByName(String name);

    @Query("SELECT p.name, pd.price, i.image FROM Product p INNER JOIN p.listImage i INNER JOIN p.listProduct pd")
    Page<Object[]> findAllPage(Pageable pageable);
}
