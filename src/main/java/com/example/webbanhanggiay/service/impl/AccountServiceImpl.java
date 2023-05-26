package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.LoginDTO;
import com.example.webbanhanggiay.dto.RegisterDTO;
import com.example.webbanhanggiay.entity.User;
import com.example.webbanhanggiay.repository.AccountRepository;
import com.example.webbanhanggiay.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public LoginDTO findByName(String name, String password) {
        User user = accountRepository.findByName(name);
        LoginDTO loginDTO = new LoginDTO();
        if (user != null) {
            loginDTO.setName(user.getName());
            loginDTO.setPassword(user.getPassword());
        }
        return loginDTO;
    }

    @Override
    public RegisterDTO create(RegisterDTO registerDTO) {
        User user = new User();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        user = accountRepository.save(user);

        registerDTO.setName(user.getName());
        registerDTO.setEmail(user.getEmail());
        registerDTO.setPassword(user.getPassword());
        return registerDTO;
    }
}