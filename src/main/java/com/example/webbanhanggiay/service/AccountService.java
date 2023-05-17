package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.LoginDTO;
import com.example.webbanhanggiay.dto.RegisterDTO;

public interface AccountService {

    LoginDTO findByName(String name,String password);

    RegisterDTO create(RegisterDTO registerDTO);

}
