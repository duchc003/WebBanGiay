package com.example.webbanhanggiay.controller;

import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.dto.ProductDetailDTO;
import com.example.webbanhanggiay.entity.Category;
import com.example.webbanhanggiay.service.impl.ProductManagerServiceImpl;
import com.example.webbanhanggiay.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductManagerServiceImpl categoryService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        List<ProductDTO> results = productServiceImpl.findByProductData();
        List<Category> categoryList = categoryService.getALL();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("list", results);
        return "index";
    }

    @GetMapping("view-product")
    public String sanPham(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                          @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                          Model model) {
        if (pageNumber < 0) {
            pageNumber = 0;
        }
        List<Category> categoryList = categoryService.getALL();
        Page<ProductDTO> results = productServiceImpl.getAllProduct(pageNumber, pageSize);
        List<ProductDTO> productList = results.getContent();
        model.addAttribute("list", productList);
        model.addAttribute("results", results);
        model.addAttribute("categoryList", categoryList);
        return "/product/product";
    }

    @GetMapping("view-product/category/{categoryId}")
    public String findByCategory(@PathVariable("categoryId") Integer categoryId,
                                 @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                                 @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                                 Model model) {
        List<CategoryDetailDTO> categoryDetailDTOList = categoryService.listProductByCategory(categoryId);
        List<Category> categoryList = categoryService.getALL();
        Page<ProductDTO> results = productServiceImpl.getAllProduct(pageNumber, pageSize);
        List<ProductDTO> productList = results.getContent();
        model.addAttribute("list", productList);
        model.addAttribute("results", results);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("categoryDTOList", categoryDetailDTOList);
        return "forward:/product/view-product";
    }

    @GetMapping("product-detail/{name}")
    public String detailProduct(@PathVariable("name") String name, Model model) {
        ProductDetailDTO productDetailDTO = productServiceImpl.getOneDetailProduct(name);
        model.addAttribute("productDetailDTO",productDetailDTO);
        return "product/product-detail";
    }

    @GetMapping("search")
    public String findByName(@PathVariable("name") String name,Model model){
        ProductDTO productDTO = productServiceImpl.searchByName(name);
        model.addAttribute("list",productDTO);
        return "forward:/product/hien-thi";
    }
    // trang-chu sản phẩm chưa load đúng mỗi sản phẩm chỉ 1 ảnh
    // sản phẩm nổi bật thiết ke lại
    // view-product cũng vậy
    // category cũng phải có page
    // xử lý đăng xuất
    // thiết kế giao diện admin
    // Thêm session
}
