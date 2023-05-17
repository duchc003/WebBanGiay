package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.LoginDTO;
import com.example.webbanhanggiay.dto.RegisterDTO;
import com.example.webbanhanggiay.service.impl.AccountServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("login")
    public String showFormLogin(Model model) {
        model.addAttribute("login", new LoginDTO());
        return "/user/login";
    }

    @PostMapping("login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        Model model) {
        LoginDTO loginDTO = accountService.findByName(name, password);
        if (loginDTO != null && loginDTO.getName().equals(name) && loginDTO.getPassword().equals(password)) {
            return "redirect:/product/hien-thi";
        } else {
            model.addAttribute("message", "Invalid username or password");
            return "/user/login";
        }
    }

    @GetMapping("register")
    public String showFormRegister(Model model) {
        model.addAttribute("register", new RegisterDTO());
        return "/user/register";
    }

    @PostMapping("register")
    public String Register(@Valid RegisterDTO registerDTO, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("view","/view/user/register.jsp");
            return "/user/register";
        } else {
            registerDTO = accountService.create(registerDTO);
            return "/user/login";
        }
    }

    @GetMapping("forgot-password")
    public String formForgotPassword() {
        return "/user/forgot-password";
    }
}
