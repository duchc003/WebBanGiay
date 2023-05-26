package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.entity.Origin;
import com.example.webbanhanggiay.repository.OriginRepository;
import com.example.webbanhanggiay.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginServiceImpl implements OriginService {

    @Autowired
    private OriginRepository originRepository;

    @Override
    public List<Origin> getAll() {
        List<Origin> getAll = originRepository.findAll();
        return getAll;
    }
}
