package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.entity.Category;
import com.example.webbanhanggiay.entity.Color;
import com.example.webbanhanggiay.entity.Origin;
import com.example.webbanhanggiay.entity.Size;
import com.example.webbanhanggiay.service.impl.ProductManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/product-manager/")
public class ProductManagerController {

    @Autowired
    private ProductManagerServiceImpl categoryServiceImpl;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        List<Category> category = categoryServiceImpl.getALL();
        List<Origin> origin = categoryServiceImpl.getALLOrigin();
        List<Color> color = categoryServiceImpl.getALLColor();
        List<Size> size = categoryServiceImpl.getALLSize();
        model.addAttribute("listCategory",category);
        model.addAttribute("listOrigin",origin);
        model.addAttribute("listColor",color);
        model.addAttribute("listSize",size);
        return "admin/product-management";
    }

    @GetMapping("view-create")
    public String viewCreate(Model model){
        List<Category> category = categoryServiceImpl.getALL();
        List<Origin> origin = categoryServiceImpl.getALLOrigin();
        List<Color> color = categoryServiceImpl.getALLColor();
        List<Size> size = categoryServiceImpl.getALLSize();
        model.addAttribute("listCategory",category);
        model.addAttribute("listOrigin",origin);
        model.addAttribute("listColor",color);
        model.addAttribute("listSize",size);
        return "admin/view-create";
    }

    @GetMapping("view-update")
    public String viewUpdate(Model model){
        List<Category> category = categoryServiceImpl.getALL();
        List<Origin> origin = categoryServiceImpl.getALLOrigin();
        List<Color> color = categoryServiceImpl.getALLColor();
        List<Size> size = categoryServiceImpl.getALLSize();
        model.addAttribute("listCategory",category);
        model.addAttribute("listOrigin",origin);
        model.addAttribute("listColor",color);
        model.addAttribute("listSize",size);
        return "admin/view-update";
    }

    @PostMapping("update")
    public String update(Model model){
        return "admin/view-update";
    }

    @PostMapping("create")
    public String create(Model model){
        return "admin/view-create";
    }

    @PostMapping("create")
    public String delete(Model model){
        return "admin/view-create";
    }
}
