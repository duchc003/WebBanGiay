package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.entity.Category;
import com.example.webbanhanggiay.service.impl.CategoryServiceImpl;
import com.example.webbanhanggiay.service.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        List<Category> categoryList = categoryService.getALL();
        List<ProductDTO> results = productServiceImpl.findByProductData();
        model.addAttribute("list", results);
        model.addAttribute("categoryList", categoryList);
        return "index";
    }

    @GetMapping("view-product")
    public String sanPham(@RequestParam(value = "number", defaultValue = "0") Integer pageNo,
                          @RequestParam(value = "size", defaultValue = "9") Integer pageSize,
                          Model model) {
        if (pageNo < 0) {
            pageNo = 0;
        }
        List<Category> categoryList = categoryService.getALL();
        Page<ProductDTO> results = productServiceImpl.getAllProduct(pageNo, pageSize);
        List<ProductDTO> productList = results.getContent();
        model.addAttribute("list", productList);
        model.addAttribute("categoryList", categoryList);
        return "/product/product";
    }

    @GetMapping("view-product/{categoryId}")
    public String findByCategory(@PathVariable("categoryId") Integer categoryId, Model model) {
        List<CategoryDetailDTO> categoryDetailDTOList = categoryService.listProductByCategory(categoryId);
        model.addAttribute("categoryDTOList", categoryDetailDTOList);
        return "product/product";
    }

//    @GetMapping()
//    public String findByName(@PathVariable("name") String name, Model model, HttpServletRequest request) {
//        ProductDTO productDTO = productServiceImpl.findByName(name);
//        model.addAttribute("productDTO", productDTO);
//
//        String getPath = request.getServletPath();
//        if (getPath.equals("hien-thi")) {
//            return "index";
//        }
//        return "product/product";
//    }
}
