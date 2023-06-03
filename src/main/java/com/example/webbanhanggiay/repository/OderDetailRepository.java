package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.entity.OderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderDetailRepository extends JpaRepository<OderDetail,Integer> {
}
