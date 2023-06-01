package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.CartDTO;
import com.example.webbanhanggiay.dto.CartDetailDTO;
import com.example.webbanhanggiay.entity.Cart;
import com.example.webbanhanggiay.entity.CartDetail;
import com.example.webbanhanggiay.entity.User;
import org.springframework.security.core.Authentication;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    CartDTO create(CartDTO cartDTO, User user);

    List<CartDetailDTO> cartDetailDTO(User user);

    CartDetail update(Integer id, User user,Integer quantity);

    boolean delete(Integer id, User user);

}
