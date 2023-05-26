package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.entity.Color;
import com.example.webbanhanggiay.repository.ColorRepository;
import com.example.webbanhanggiay.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        List<Color> getAll = colorRepository.findAll();
        return getAll;
    }
}
