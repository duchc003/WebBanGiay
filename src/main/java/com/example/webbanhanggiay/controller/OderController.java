package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.OderDTO;
import com.example.webbanhanggiay.entity.Oder;
import com.example.webbanhanggiay.entity.OderDetail;
import com.example.webbanhanggiay.entity.User;
import com.example.webbanhanggiay.service.impl.OderServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oder/")
public class OderController {

    @Autowired
    private HttpSession session;

    private OderServiceImpl oderService;

    @GetMapping("hien-thi")
    public String hienThi(){
        return "admin/oder";
    }

    @GetMapping("detail")
    public String oderDetail(){
        return "admin/oder-detail";
    }

    @PostMapping
    public String createOder(@PathVariable OderDTO oderDTO, Model model){
        try {
            User user = (User) session.getAttribute("loggedInUser");
            Oder oder = new Oder();
            OderDetail oderDetail = new OderDetail();
            oderDTO = oderService.create(user,oder,oderDetail,oderDTO);
            session.setAttribute("message","Đặt Hàng Thành Công");
        }catch (Exception e){
            e.printStackTrace();
            session.setAttribute("error","Đặt Hàng Thất Bại");
        }
        return "";
    }
}
