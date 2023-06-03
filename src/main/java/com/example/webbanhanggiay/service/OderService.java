package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.CartDetailDTO;
import com.example.webbanhanggiay.dto.DonHangDTO;
import com.example.webbanhanggiay.dto.OderDTO;
import com.example.webbanhanggiay.dto.QLDonHangDTO;
import com.example.webbanhanggiay.entity.Oder;
import com.example.webbanhanggiay.entity.User;

import java.util.List;

public interface OderService {

    OderDTO create(User user, Oder oder, List<CartDetailDTO> cartDetailDTOS, OderDTO oderDTO);

    List<DonHangDTO> choThanhToan(User user);

    List<DonHangDTO> vanChuyen(User user);

    List<DonHangDTO> dangGiao(User user);

    List<DonHangDTO> hoanThanh(User user);

    List<DonHangDTO> daHuy(User user);

    List<QLDonHangDTO> quanLyDonHang();
}
