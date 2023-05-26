package com.example.webbanhanggiay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @GetMapping("dashboard")
    public String admin(){
        return "admin/dashboard";
    }

    @GetMapping("customer")
    public String customer(){
        return "customer/customer";
    }
}
