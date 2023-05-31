package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.CartDTO;
import com.example.webbanhanggiay.dto.CartDetailDTO;
import com.example.webbanhanggiay.entity.*;
import com.example.webbanhanggiay.repository.*;
import com.example.webbanhanggiay.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public CartDTO create(CartDTO cartDTO, User user) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        ProductDetail existingProduct = productDetailRepository.findById(cartDTO.getIdProduct()).orElse(null);

        Cart cart = new Cart();
        cart.setUnitPrice(cartDTO.getUnitPrice());
        cart.setUser(user);
        cartRepository.save(cart);

        CartDetail cartDetail = new CartDetail();
        cartDetail.setCart(cart);
        cartDetail.setProductDetail(existingProduct);
        cartDetail.setDateCreate(timestamp);
        cartDetail.setQuantity(1);
        cartDetailRepository.save(cartDetail);
        return cartDTO;
    }

    @Override
    public List<CartDetailDTO> cartDetailDTO(User user) {
        List<Object[]> listObjects = cartDetailRepository.getCartDetail(user);
        List<CartDetailDTO> cartDetailDTO = new ArrayList<>();
        for (Object[] x : listObjects) {
            String image = (String) x[0];
            String productName = (String) x[1];
            BigDecimal price = (BigDecimal) x[2];
            BigDecimal unitPrice = (BigDecimal) x[3];
            Integer quantity = (Integer) x[4];
            CartDetailDTO detailDTO = new CartDetailDTO(image, productName, unitPrice, price, quantity);
            cartDetailDTO.add(detailDTO);
        }
        return cartDetailDTO;
    }

    @Override
    public CartDetailDTO sumPriceInCart(User user) {
        List<Object[]> listObjects = cartDetailRepository.sumPriceInCart(user);
        Object[] objects = listObjects.get(0);
        String image = (String) objects[0];
        String name = (String) objects[1];
        BigDecimal unitPrice = (BigDecimal) objects[2];
        BigDecimal totalPrice = (BigDecimal) objects[3];
        Integer quantity = (Integer) objects[4];
        CartDetailDTO detailDTO = new CartDetailDTO(image, name, unitPrice, totalPrice, quantity);
        return detailDTO;
    }

    @Override
    public CartDetail update(CartDetail cartDetail, User user) {
        return cartDetailRepository.save(cartDetail);
    }

    @Override
    public boolean delete(CartDetail cartDetail, User user) {
        try {
            cartDetailRepository.delete(cartDetail);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
