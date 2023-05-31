package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.RegisterDTO;
import com.example.webbanhanggiay.entity.User;
import com.example.webbanhanggiay.repository.UserRepository;
import com.example.webbanhanggiay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name, String password) {
        User user = userRepository.findByName(name);
        return user;
    }

    @Override
    public RegisterDTO create(RegisterDTO registerDTO) {
        User user = new User();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        user = userRepository.save(user);

        registerDTO.setName(user.getName());
        registerDTO.setEmail(user.getEmail());
        registerDTO.setPassword(user.getPassword());
        return registerDTO;
    }

    @Override
    public User findByUser(User user) {
        return userRepository.findByUser(user);
    }
}