package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.DiscountDTO;
import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.entity.Product;
import com.example.webbanhanggiay.repository.ProductRepository;
import com.example.webbanhanggiay.service.ProductService;
import com.example.webbanhanggiay.service.impl.DiscountServiceImpl;
import com.example.webbanhanggiay.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/discount/")
public class DiscountController {

    @Autowired
    private DiscountServiceImpl discountServiceImpl;

    @GetMapping("hien-thi")
    public String viewDiscount(Model model) {
        List<Product> results = discountServiceImpl.getAll();
        model.addAttribute("list", results);
        model.addAttribute("discountDTO",new DiscountDTO());
        return "discount/view-discount";
    }

    public String createDiscount(@Valid @ModelAttribute("discountDTO") DiscountDTO discountDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            return "discount/view-discount";
        }
        return "discount/view-discount";
    }

    @ModelAttribute("HinhThucKhuyenMai")
    public Map<Integer, String> getHinhThucDiscount() {
        Map<Integer, String> getHinhThucDiscount = new HashMap<Integer, String>();
        getHinhThucDiscount.put(1, "Giảm Theo %");
        getHinhThucDiscount.put(2, "Giảm Theo Số Tiền");
        return getHinhThucDiscount;
    }
}
