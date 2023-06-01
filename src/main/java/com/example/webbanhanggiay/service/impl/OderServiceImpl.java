package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.OderDTO;
import com.example.webbanhanggiay.entity.Oder;
import com.example.webbanhanggiay.entity.OderDetail;
import com.example.webbanhanggiay.entity.ProductDetail;
import com.example.webbanhanggiay.entity.User;
import com.example.webbanhanggiay.repository.OderDetailRepository;
import com.example.webbanhanggiay.repository.OderRepository;
import com.example.webbanhanggiay.repository.ProductDetailRepository;
import com.example.webbanhanggiay.service.OderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;

@Service
public class OderServiceImpl implements OderService {

    @Autowired
    private OderRepository oderRepository;

    @Autowired
    private OderDetailRepository oderDetailRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public OderDTO create(User user, Oder oder, OderDetail oderDetail, OderDTO oderDTO) {
        ProductDetail productDetail = productDetailRepository.findById(oderDTO.getIdProduct())
                .orElseGet(() -> {
                    return null;
                });

        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(oderDTO, oder);
        oder.setUser(user);
        oder.setNgayDatHang(timestamp);
        oder.setStatus(1);
        oderRepository.save(oder);

        oderDetail.setOder(oder);
        oderDetail.setProductDetail(productDetail);
        oderDetail.setQuantity(oderDTO.getQuantity());
        oderDetail.setTotalMoney(oderDTO.getTotalMoney());
        oderDetailRepository.save(oderDetail);

        return oderDTO;
    }
}
