package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.CartDTO;
import com.example.webbanhanggiay.dto.CartDetailDTO;
import com.example.webbanhanggiay.entity.CartDetail;
import com.example.webbanhanggiay.entity.User;
import com.example.webbanhanggiay.service.impl.CartServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewCart(Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        List<CartDetailDTO> cartDetailDTOS = cartService.cartDetailDTO(user);
        CartDetailDTO detailDTO = cartService.sumPriceInCart(user);
        model.addAttribute("cartDetailDTOS", cartDetailDTOS);
        model.addAttribute("total", detailDTO);
        return "product/cart";
    }

    @PostMapping("create")
    public String create(@ModelAttribute CartDTO cartDTO, Model model, HttpSession session) {
        try {
            User user = (User) session.getAttribute("loggedInUser");
            cartDTO.setIdCustomer(user.getId());
            cartService.create(cartDTO, user);
            session.setAttribute("message", "Thêm Vào Giỏ Hàng Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Vào Giỏ Hàng Thất bại");
        }
        return "redirect:/product/hien-thi";
    }

    @PostMapping("update")
    public String updadeQuantityCart(@ModelAttribute("cart") CartDetail cartDetail, @RequestParam("deleteFlag") boolean deleteFlag) {
        try {
            User user = (User) session.getAttribute("loggedInUser");
            if (deleteFlag) {
                cartService.delete(cartDetail, user);
            } else {
                cartDetail = cartService.update(cartDetail, user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/cart/hien-thi";
    }

}