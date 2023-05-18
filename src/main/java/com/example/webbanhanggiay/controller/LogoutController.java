package com.example.webbanhanggiay.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

@Controller
public class LogoutController {

    @GetMapping
    public String logout(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            SecurityContextHolder.clearContext();
        }
        return "redirect:/user/login";
    }
}
