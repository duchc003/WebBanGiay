package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.dto.ProductDetailDTO;
import com.example.webbanhanggiay.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p.name, i.image, pd.price " +
            "FROM Product p " +
            "JOIN p.listImage i " +
            "JOIN p.listProduct pd"
    )
    List<Object[]> findAllProductDetails();

    @Query("SELECT p.name, i.image, pd.price " +
            "FROM Product p " +
            "JOIN p.listImage i " +
            "JOIN p.listProduct pd " +
            "WHERE pd.category.id = :categoryId")
    List<Object[]> listProductByCategory(Integer categoryId);

    Product findByName(String name);

    @Query("SELECT p.name, pd.price, i.image FROM Product p INNER JOIN p.listImage i INNER JOIN p.listProduct pd")
    Page<Object[]> findAllPage(Pageable pageable);

    @Query("SELECT p.name, pd.price, p.description, cl.name, s.size, i.image " +
            "FROM Product p " +
            "JOIN p.listProduct pd " +
            "JOIN p.listImage i " +
            "JOIN pd.color cl " +
            "JOIN pd.size s " +
            "WHERE p.name = :name")
    List<Object[]> getOneDetailProduct(@Param("name") String name);

    @Query("SELECT p.name, i.image, pd.price " +
            "FROM Product p " +
            "JOIN p.listImage i " +
            "JOIN p.listProduct pd " +
            "WHERE p.name LIKE %:name%")
    List<Object[]> searchByName(@Param("name") String name);
}
