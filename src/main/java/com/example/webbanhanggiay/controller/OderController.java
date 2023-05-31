package com.example.webbanhanggiay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oder/")
public class OderController {

    @GetMapping("hien-thi")
    public String hienThi(){
        return "admin/oder";
    }

    @GetMapping("detail")
    public String oderDetail(){
        return "admin/oder-detail";
    }
}
