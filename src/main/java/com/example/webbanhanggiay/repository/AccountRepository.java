package com.example.webbanhanggiay.repository;

import com.example.webbanhanggiay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<User,Integer> {

    User findByName(String name);

}
