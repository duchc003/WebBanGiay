package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface ImageRepository extends JpaRepository<Image,Integer> {


}
