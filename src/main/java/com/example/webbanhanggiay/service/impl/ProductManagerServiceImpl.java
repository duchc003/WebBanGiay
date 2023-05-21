package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.CategoryDetailDTO;
import com.example.webbanhanggiay.dto.ProductManagerDTO;
import com.example.webbanhanggiay.entity.*;
import com.example.webbanhanggiay.repository.*;
import com.example.webbanhanggiay.service.ProductManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManagerServiceImpl implements ProductManagerService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OriginRepository originRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<CategoryDetailDTO> listProductByCategory(Integer categoryId) {
        List<Object[]> result = productRepository.listProductByCategory(categoryId);
        List<CategoryDetailDTO> categoryDetailDTOList = new ArrayList<>();

        for (Object[] listObjects : result) {
            String name = (String) listObjects[0];
            String image = (String) listObjects[1];
            Float price = (Float) listObjects[2];
            CategoryDetailDTO categoryDetailDTO = new CategoryDetailDTO(name, image, price);
            categoryDetailDTOList.add(categoryDetailDTO);
        }
        return categoryDetailDTOList;
    }

    @Override
    public List<Category> getALL() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @Override
    public List<Origin> getALLOrigin() {
        List<Origin> getALLOrigin = originRepository.findAll();
        return getALLOrigin;
    }

    @Override
    public List<Color> getALLColor() {
        List<Color> getALLOrigin = colorRepository.findAll();
        return getALLOrigin;
    }

    @Override
    public List<Size> getALLSize() {
        List<Size> getALLSize = sizeRepository.findAll();
        return getALLSize;
    }

    @Override
    public ProductManagerDTO save(ProductManagerDTO productManagerDTO, Image image, ProductDetail productDetail) {
        Product existingProduct = productRepository.findByName(productManagerDTO.getName());//find name lấy id
        Category category = categoryRepository.findByName(productManagerDTO.getCategory());//find name lấy id
        Size size = sizeRepository.findBySize(productManagerDTO.getSize());//find name lấy id
        Origin origin = originRepository.findByName(productManagerDTO.getOrigin());//find name lấy id

        Product product;
        if (existingProduct != null) {
            product = existingProduct;
        } else {
            product = new Product();
            product.setName(productManagerDTO.getName());
            product.setDescription(productManagerDTO.getDescription());
            product = productRepository.save(product);
        }

        image.setImage(productManagerDTO.getImage());
        image.setProduct(product);
        image = imageRepository.save(image);

        productDetail.setProduct(product);
        productDetail.setCategory(category);
        productDetail.setSize(size);
        productDetail.setOrigin(origin);
        productDetail.setQuantity(productManagerDTO.getQuantity());
        productDetail.setPrice(productManagerDTO.getPrice());
        productDetail = productDetailRepository.save(productDetail);

        return productManagerDTO;
    }

    @Override
    public List<ProductManagerDTO> selectAllProduct() {
        List<Object[]> result = productDetailRepository.selectAllProduct();
        List<ProductManagerDTO> productManagerDTOList = new ArrayList<>();
        for (Object[] list: result){
             String name = (String) list[0];
             String color = (String) list[1];
             Integer size = (Integer) list[2];
             String category = (String) list[3];
             String origin = (String) list[4];
             Integer quantity = (Integer) list[5];
             Float price = (Float) list[6];
             String description = (String) list[7];
             String image = (String) list[8];
            ProductManagerDTO productManagerDTO = new ProductManagerDTO(name,color,size,category,origin,quantity,price,description,image);
            productManagerDTOList.add(productManagerDTO);
        }
        return productManagerDTOList;
    }

    @Override
    public Integer countProduct(){
        Integer productList = productRepository.countProduct();
        return productList;
    }
}
