package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size,Integer> {

    Size findBySize(Integer size);
}
