package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.ProductDetailDTO;
import com.example.webbanhanggiay.dto.ProductManagerDTO;
import com.example.webbanhanggiay.entity.*;
import com.example.webbanhanggiay.service.impl.ProductManagerServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product-manager/")
public class ProductManagerController {

    @Autowired
    private ProductManagerServiceImpl productManagerService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("hien-thi-product")
    public String hienThi(Model model) {
        List<Category> category = productManagerService.getALL();
        List<Origin> origin = productManagerService.getALLOrigin();
        List<Color> color = productManagerService.getALLColor();
        List<Size> size = productManagerService.getALLSize();
        List<ProductManagerDTO> productDetailDTOList = productManagerService.selectAllProduct();
        Integer soLuong = productManagerService.countProduct();
        model.addAttribute("listCategory", category);
        model.addAttribute("listOrigin", origin);
        model.addAttribute("listColor", color);
        model.addAttribute("listSize", size);
        model.addAttribute("productDetailDTOList",productDetailDTOList);
        model.addAttribute("soLuong", soLuong);
        return "admin/product-management";
    }

    @GetMapping("view-create")
    public String viewCreate(Model model) {
        List<Category> category = productManagerService.getALL();
        List<Origin> origin = productManagerService.getALLOrigin();
        List<Color> color = productManagerService.getALLColor();
        List<Size> size = productManagerService.getALLSize();
        model.addAttribute("listCategory", category);
        model.addAttribute("listOrigin", origin);
        model.addAttribute("listColor", color);
        model.addAttribute("listSize", size);
        model.addAttribute("productManagerDTO", new ProductManagerDTO());
        return "admin/view-create";
    }

    @GetMapping("view-update")
    public String viewUpdate(Model model) {
        List<Category> category = productManagerService.getALL();
        List<Origin> origin = productManagerService.getALLOrigin();
        List<Color> color = productManagerService.getALLColor();
        List<Size> size = productManagerService.getALLSize();
        model.addAttribute("listCategory", category);
        model.addAttribute("listOrigin", origin);
        model.addAttribute("listColor", color);
        model.addAttribute("listSize", size);
        return "admin/view-update";
    }

    @PostMapping("update")
    public String update(Model model) {
        return "admin/view-update";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute("productManagerDTO") ProductManagerDTO productManagerDTO, BindingResult results) {
        try {
            if (results.hasErrors()) {
                return "admin/view-create";
            }
            ProductDetail productDetail = new ProductDetail();
            Product product = new Product();
            Image image = new Image();
            productManagerDTO = productManagerService.save(productManagerDTO, image, productDetail);
            httpSession.setAttribute("message", "Add Thành Công");
        } catch (Exception ex) {
            httpSession.setAttribute("error", "Add thất bại");
            ex.printStackTrace();
        }
        return "redirect:/admin/product-manager/hien-thi";
    }

}
