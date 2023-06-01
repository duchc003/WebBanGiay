package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.CartDetailDTO;
import com.example.webbanhanggiay.entity.User;
import com.example.webbanhanggiay.service.impl.CartServiceImpl;
import com.example.webbanhanggiay.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private HttpSession session;

    @GetMapping("all-oder")
    public String allOder(){
        return "customer/all-oder";
    }

    @GetMapping("cho-thanh-toan")
    public String choThanhToan(){
        return "customer/cho-thanh-toan";
    }

    @GetMapping("van-chuyen")
    public String vanChuyen(){
        return "customer/van-chuyen";
    }

    @GetMapping("dang-giao")
    public String dangGiao(){
        return "customer/dang-giao";
    }

    @GetMapping("hoan-thanh")
    public String hoanThanh(){
        return "customer/hoan-thanh";

    }@GetMapping("da-huy")
    public String daHuy(){
        return "customer/da-huy";
    }

    @GetMapping("traHangHoanTat")
    public String traHangHoanTat(){
        return "customer/tra-hang-hoan-tien";
    }

    @GetMapping("khach-hang")
    public String khachHang(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        User foundUser = userService.findByUser(loggedInUser);
        model.addAttribute("user", foundUser);
        return "customer/khach";
    }

    @GetMapping("view-thanh-toan")
    public String viewThanhToan(Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        List<CartDetailDTO> cartDetailDTOS = cartService.cartDetailDTO(user);
        model.addAttribute("cartDetailDTOS", cartDetailDTOS);
        return "product/view-thanh-toan";
    }
}
