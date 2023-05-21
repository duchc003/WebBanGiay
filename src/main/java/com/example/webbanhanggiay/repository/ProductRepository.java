package com.example.webbanhanggiay.repository;

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

    @Query("SELECT p.name AS name, pd.price AS price, MIN(i.image) AS image " +
            "FROM Product p " +
            "LEFT JOIN p.listProduct pd " +
            "LEFT JOIN p.listImage i GROUP BY p.name,pd.price")
    List<Object[]> findAllProductDetails();

    @Query("SELECT p.name, MIN(i.image), pd.price " +
            "FROM Product p " +
            "LEFT JOIN p.listImage i " +
            "LEFT JOIN p.listProduct pd " +
            "WHERE pd.category.id = :categoryId GROUP BY p.name,pd.price")
    List<Object[]> listProductByCategory(@Param("categoryId") Integer categoryId);

    Product findByName(String name);

    @Query("SELECT p.name AS name, pd.price AS price, MIN(i.image) AS image " +
            "FROM Product p " +
            "LEFT JOIN p.listProduct pd " +
            "LEFT JOIN p.listImage i GROUP BY p.name,pd.price")
    Page<Object[]> findAllPage(Pageable pageable);

    @Query("SELECT p.name, pd.price, p.description, cl.name, s.size, MIN(i.image) " +
            "FROM Product p " +
            "LEFT JOIN p.listProduct pd " +
            "LEFT JOIN p.listImage i " +
            "LEFT JOIN pd.color cl " +
            "LEFT JOIN pd.size s " +
            "WHERE p.name = :name GROUP BY p.name,pd.price")
    List<Object[]> getOneDetailProduct(@Param("name") String name);

    @Query("SELECT p.name, MIN(i.image), pd.price " +
            "FROM Product p " +
            "LEFT JOIN p.listImage i " +
            "LEFT JOIN p.listProduct pd " +
            "WHERE p.name LIKE %:name% GROUP BY p.name,pd.price")
    List<Object[]> searchByName(@Param("name") String name);

    @Query("SELECT COUNT(p.id) From Product p " +
            "JOIN p.listImage i " +
            "JOIN p.listProduct pd " +
            "JOIN pd.category c " +
            "JOIN pd.size s " +
            "JOIN pd.origin o " +
            "JOIN pd.color cl ")
    Integer countProduct();
}
