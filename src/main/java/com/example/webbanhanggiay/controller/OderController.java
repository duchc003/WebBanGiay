package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.CartDetailDTO;
import com.example.webbanhanggiay.dto.DonHangDTO;
import com.example.webbanhanggiay.dto.OderDTO;
import com.example.webbanhanggiay.dto.QLDonHangDTO;
import com.example.webbanhanggiay.entity.Oder;
import com.example.webbanhanggiay.entity.OderDetail;
import com.example.webbanhanggiay.entity.User;
import com.example.webbanhanggiay.service.impl.CartServiceImpl;
import com.example.webbanhanggiay.service.impl.OderServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/oder/")
public class OderController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private HttpSession session;

    @Autowired
    private OderServiceImpl oderService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        List<QLDonHangDTO> donHangDTOList = oderService.quanLyDonHang();
        model.addAttribute("donHangDTOList", donHangDTOList);
        return "admin/oder";
    }

    @GetMapping("detail")
    public String oderDetail() {
        return "admin/oder-detail";
    }

    @GetMapping("view-thanh-toan")
    public String viewThanhToan(Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        List<CartDetailDTO> cartDetailDTOS = cartService.cartDetailDTO(user);
        model.addAttribute("cartDetailDTOS", cartDetailDTOS);
        model.addAttribute("oderDTO", new OderDTO());
        return "customer/view-thanh-toan";
    }

    @PostMapping("create")
    public String createOder(@Valid @ModelAttribute("oderDTO") OderDTO oderDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return "customer/view-thanh-toan";
            }
            User user = (User) session.getAttribute("loggedInUser");
            Oder oder = new Oder();
            List<CartDetailDTO> cartDetailDTOS = cartService.cartDetailDTO(user);
            oderDTO = oderService.create(user, oder, cartDetailDTOS, oderDTO);
            session.setAttribute("message", "Đặt Hàng Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Đặt Hàng Thất Bại");
        }
        return "customer/view-thanh-toan";
    }

}
