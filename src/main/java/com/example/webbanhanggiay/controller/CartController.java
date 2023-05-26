package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.CartDTO;
import com.example.webbanhanggiay.dto.UserDTO;
import com.example.webbanhanggiay.service.impl.CartServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewCart() {
        return "product/cart";
    }

    @PostMapping("create")
    public String create(@RequestBody CartDTO cartDTO, Authentication authentication, Model model) {
        try {
            cartService.create(cartDTO, authentication);
            model.addAttribute("message", "Thêm Vào Giỏ Hàng Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Thêm Vào Giỏ Hàng Thất bại");
        }
        return "index";
    }
}