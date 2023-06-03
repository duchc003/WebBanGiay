package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.CartDetailDTO;
import com.example.webbanhanggiay.dto.DonHangDTO;
import com.example.webbanhanggiay.dto.OderDTO;
import com.example.webbanhanggiay.dto.QLDonHangDTO;
import com.example.webbanhanggiay.entity.*;
import com.example.webbanhanggiay.repository.CartDetailRepository;
import com.example.webbanhanggiay.repository.OderDetailRepository;
import com.example.webbanhanggiay.repository.OderRepository;
import com.example.webbanhanggiay.repository.ProductDetailRepository;
import com.example.webbanhanggiay.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OderServiceImpl implements OderService {

    @Autowired
    private OderRepository oderRepository;

    @Autowired
    private OderDetailRepository oderDetailRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Override
    public OderDTO create(User user, Oder oder, List<CartDetailDTO> cartDetailDTOS, OderDTO oderDTO) {
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        oder.setRecipientName(oderDTO.getRecipientName());
        oder.setAddress(oderDTO.getAddress());
        oder.setPhone(oderDTO.getPhone());
        oder.setUser(user);
        oder.setNgayDatHang(timestamp);
        oder.setStatus(1);
        oder.setThanhTien(oderDTO.getThanhTien());
        oderRepository.save(oder);
        for (CartDetailDTO c : cartDetailDTOS) {
            OderDetail oderDetail = new OderDetail();
            ProductDetail productDetail = productDetailRepository.findById(c.getIdProductDetail())
                    .orElse(null);
            oderDetail.setOder(oder);
            oderDetail.setProductDetail(productDetail);
            oderDetail.setQuantity(oderDTO.getQuantity());
            oderDetail.setTotalMoney(oderDTO.getTotalMoney());
            oderDetailRepository.save(oderDetail);

            CartDetail cartDetail = cartDetailRepository.findById(c.getIdCart()).orElse(null);
            cartDetail.setStatus(2);
            cartDetailRepository.save(cartDetail);
        }
        return oderDTO;
    }

    @Override
    public List<DonHangDTO> choThanhToan(User user) {
        List<Object[]> objectList = oderRepository.choThanhToan(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String name = (String) list[0];
            Integer status = (Integer) list[1];
            DonHangDTO donHangDTO = new DonHangDTO(name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<DonHangDTO> vanChuyen(User user) {
        List<Object[]> objectList = oderRepository.vanChuyen(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String name = (String) list[0];
            Integer status = (Integer) list[1];
            DonHangDTO donHangDTO = new DonHangDTO(name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<DonHangDTO> dangGiao(User user) {
        List<Object[]> objectList = oderRepository.dangGiao(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String name = (String) list[0];
            Integer status = (Integer) list[1];
            DonHangDTO donHangDTO = new DonHangDTO(name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<DonHangDTO> hoanThanh(User user) {
        List<Object[]> objectList = oderRepository.hoanThanh(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String name = (String) list[0];
            Integer status = (Integer) list[1];
            DonHangDTO donHangDTO = new DonHangDTO(name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<DonHangDTO> daHuy(User user) {
        List<Object[]> objectList = oderRepository.daHuy(user);
        List<DonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList
        ) {
            String name = (String) list[0];
            Integer status = (Integer) list[1];
            DonHangDTO donHangDTO = new DonHangDTO(name, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }

    @Override
    public List<QLDonHangDTO> quanLyDonHang() {
        List<Object[]> objectList = oderRepository.quanLyDonHang();
        List<QLDonHangDTO> donHangDTOList = new ArrayList<>();
        for (Object[] list : objectList) {
            String hoVaTen = (String) list[0];
            Integer phone = (Integer) list[1];
            Date ngayDatHang = (Date) list[2];
            Date ngayGiaoHang = (Date) list[3];
            Date ngayNhanHang = (Date) list[4];
            BigDecimal totalMoney = (BigDecimal) list[5];
            Integer status = (Integer) list[6];
            QLDonHangDTO donHangDTO = new QLDonHangDTO(hoVaTen, phone, ngayDatHang, ngayGiaoHang, ngayNhanHang, totalMoney, status);
            donHangDTOList.add(donHangDTO);
        }
        return donHangDTOList;
    }
}
