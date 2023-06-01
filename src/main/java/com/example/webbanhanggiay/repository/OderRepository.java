package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderRepository extends JpaRepository<Oder,Integer> {
}
