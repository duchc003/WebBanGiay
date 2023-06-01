package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.OderDTO;
import com.example.webbanhanggiay.entity.Oder;
import com.example.webbanhanggiay.entity.OderDetail;
import com.example.webbanhanggiay.entity.User;

public interface OderService {

    OderDTO create(User user, Oder oder, OderDetail oderDetail, OderDTO oderDTO);
}
