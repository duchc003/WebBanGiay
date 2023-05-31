package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.RegisterDTO;
import com.example.webbanhanggiay.entity.User;

public interface UserService {

    User findByName(String name, String password);

    RegisterDTO create(RegisterDTO registerDTO);

    User findByUser(User user);
}
