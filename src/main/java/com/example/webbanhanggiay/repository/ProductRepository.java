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
import java.util.Objects;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT pd.id,p.name AS name, pd.price AS price, MIN(i.image) AS image " +
            "FROM Product p " +
            " JOIN p.listProduct pd " +
            " JOIN p.listImage i GROUP BY pd.id,p.name,pd.price")
    List<Object[]> findAllProductDetails();

    Product findByName(String name);

    @Query("SELECT pd.id, p.name AS name, pd.price AS price, MIN(i.image) AS image " +
            "FROM Product p " +
            " JOIN p.listProduct pd " +
            " JOIN p.listImage i GROUP BY pd.id,p.name,pd.price")
    Page<Object[]> findAllPage(Pageable pageable);

    @Query("SELECT pd.id,p.name AS name, pd.price AS price, MIN(i.image) AS image " +
            "FROM Product p " +
            " JOIN p.listProduct pd " +
            " JOIN p.listImage i " +
            " JOIN pd.category c " +
            "WHERE c.id = :id " +
            "GROUP BY pd.id,p.name, pd.price")
    Page<Object[]> findAllCategory(@Param("id") Integer id, Pageable pageable);

    @Query("SELECT pd.id,p.name AS name, pd.price AS price, MIN(i.image) AS image " +
            "FROM Product p " +
            " JOIN p.listProduct pd " +
            " JOIN p.listImage i " +
            " JOIN pd.category c " +
            "WHERE c.id = :id " +
            "GROUP BY pd.id,p.name, pd.price")
    List<Object[]> getAllProduct(@Param("id") Integer id);

    @Query("SELECT p.name, pd.price, p.description, cl.name, s.size, MIN(i.image) " +
            "FROM Product p " +
            " JOIN p.listProduct pd " +
            " JOIN p.listImage i " +
            " JOIN pd.color cl " +
            " JOIN pd.size s " +
            "WHERE p.name = :name GROUP BY p.name,pd.price,p.description, cl.name, s.size")
    List<Object[]> getOneDetailProduct(@Param("name") String name);

    @Query("SELECT p.name, MIN(i.image), pd.price " +
            "FROM Product p " +
            " JOIN p.listImage i " +
            " JOIN p.listProduct pd " +
            "WHERE p.name LIKE %:name% " +
            "GROUP BY p.name, pd.price")
    List<Object[]> searchByName(@Param("name") String name);

    @Query("SELECT pd.id,p.name AS name, pd.price AS price, i.image AS image " +
            "FROM Product p " +
            "JOIN p.listProduct pd  " +
            "JOIN p.listImage i where p.name = :name")
    List<Object[]> findByImage(@Param("name") String name);

    @Query("SELECT NEW com.example.webbanhanggiay.dto.ProductDTO(pd.id,p.name, pd.price, MIN(i.image)) " +
            "FROM Product p " +
            "JOIN p.listProduct pd " +
            "JOIN p.listImage i WHERE p.id = :id GROUP BY pd.id,p.name, pd.price")
    ProductDTO findByPrice(@Param("id") Integer id);

}
