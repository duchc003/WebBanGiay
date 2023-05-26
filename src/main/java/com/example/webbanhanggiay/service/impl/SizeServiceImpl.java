package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.entity.Size;
import com.example.webbanhanggiay.repository.SizeRepository;
import com.example.webbanhanggiay.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getAll() {
        List<Size> getAll = sizeRepository.findAll();
        return getAll;
    }
}
