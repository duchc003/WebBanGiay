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

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LoginDTO findByName(String name, String password) {
        User user = accountRepository.findByName(name);
        return modelMapper.map(user, LoginDTO.class);
    }

    @Override
    public RegisterDTO create(RegisterDTO registerDTO) {
        User user = new User();
        if (accountRepository.findByEmail(registerDTO.getEmail()) != null) {
            throw new RuntimeException("Email has been taken");
        }
        if (!registerDTO.getPassword().equals(registerDTO.getRepeatPassword())) {
            throw new RuntimeException("Passwords do not match");
        }
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(registerDTO.getPassword()));
        user = accountRepository.save(user);

        registerDTO.setName(user.getName());
        registerDTO.setEmail(user.getEmail());
        registerDTO.setPassword(user.getPassword());
        return registerDTO;
    }
}