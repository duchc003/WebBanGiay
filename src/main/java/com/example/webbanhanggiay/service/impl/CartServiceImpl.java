package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.CartDTO;
import com.example.webbanhanggiay.dto.UserDTO;
import com.example.webbanhanggiay.entity.*;
import com.example.webbanhanggiay.repository.*;
import com.example.webbanhanggiay.service.CartService;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public CartDTO create(CartDTO cartDTO, Authentication authentication) {

        ProductDetail existingProduct = productDetailRepository.finByName(cartDTO.getNameProduct());

        Cart cart = new Cart();
        cart.setUnitPrice(cartDTO.getUnitPrice());
        UserDTO userPrincipal = (UserDTO) authentication.getPrincipal();
        Integer userId = userPrincipal.getId();
        User user = accountRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        cart.setUser(user);
        cartRepository.save(cart);

        Integer cartId = cart.getId(); // Lấy ID của giỏ hàng sau khi lưu

        CartDetail cartDetail = new CartDetail();
        cartDetail.setCart(cart);
        cartDetail.setProductDetail(existingProduct);
        cartDetail.setDateCreate(cartDTO.getDateCreate());
        cartDetail.setDateFix(cartDTO.getDateFix());
        cartDetailRepository.save(cartDetail);

        return cartDTO;
    }
}
