package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.entity.Category;
import com.oracle.wls.shaded.org.apache.bcel.generic.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
