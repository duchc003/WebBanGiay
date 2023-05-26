package com.example.webbanhanggiay.service;

import com.example.webbanhanggiay.dto.CartDTO;
import com.example.webbanhanggiay.entity.Cart;
import org.springframework.security.core.Authentication;

public interface CartService {

    CartDTO create(CartDTO cartDTO, Authentication authentication);
}
