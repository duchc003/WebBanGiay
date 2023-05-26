package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.ProductDTO;
import com.example.webbanhanggiay.dto.ProductDetailDTO;
import com.example.webbanhanggiay.dto.ProductViewDTO;
import com.example.webbanhanggiay.entity.Product;
import com.example.webbanhanggiay.repository.ProductRepository;
import com.example.webbanhanggiay.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDTO> findByProductData() {
        List<Object[]> results = productRepository.findAllProductDetails();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Object[] reObjects : results) {
            String name = (String) reObjects[0];
            String image = (String) reObjects[2];
            Float price = (Float) reObjects[1];

            ProductDTO productDTO = new ProductDTO(name, price, image);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    @Override
    public ProductDTO findByName(String name) {
        Product product = productRepository.findByName(name);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public Page<ProductDTO> getAllProduct(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo < 0) {
            pageNo = 0;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 9;
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Object[]> pageObjects = productRepository.findAllPage(pageable);
        List<Object[]> listObjects = pageObjects.getContent();
        List<ProductDTO> productDTOList = listObjects.stream()
                .map(objects -> new ProductDTO(
                        (String) objects[0],
                        (Float) objects[1],
                        (String) objects[2]))
                .collect(Collectors.toList());
        return new PageImpl<>(productDTOList, pageable, pageObjects.getTotalElements());
    }

    @Override
    public Page<ProductDTO> getAllByProduct(Integer categoryId, Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo < 0) {
            pageNo = 0;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 9;
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Object[]> pageObjects = productRepository.findAllCategory(categoryId,pageable);
        List<Object[]> listObjects = pageObjects.getContent();
        List<ProductDTO> productDTOList = listObjects.stream()
                .map(objects -> new ProductDTO(
                        (String) objects[0],
                        (Float) objects[1],
                        (String) objects[2]))
                .collect(Collectors.toList());
        return new PageImpl<>(productDTOList, pageable, pageObjects.getTotalElements());
    }

    @Override
    public List<ProductDTO> getAllProductByCate(Integer categoryId) {
        List<Object[]> getAllProduct = productRepository.getAllProduct(categoryId);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Object[] list : getAllProduct) {
            String ten = (String) list[0];
            Float price = (Float) list[1];
            String image = (String) list[2];
            ProductDTO productDTO = new ProductDTO(ten,price,image);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findByImage(String name) {
        List<Object[]> listObjects = productRepository.findByImage(name);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Object[] list : listObjects) {
            String ten = (String) list[0];
            Float price = (Float) list[1];
            String image = (String) list[2];
            ProductDTO productDTO = new ProductDTO(ten,price,image);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public ProductDetailDTO getOneDetailProduct(String name) {
        List<Object[]> result = productRepository.getOneDetailProduct(name);
        Object[] row = result.get(0);
        String ten = (String) row[0];
        Float price = (Float) row[1];
        String description = (String) row[2];
        String color = (String) row[3];
        Integer size = (Integer) row[4];
        String image = (String) row[5];
        ProductDetailDTO productDetailDTO = new ProductDetailDTO(ten, price, description, color, size, image);
        return productDetailDTO;
    }

    @Override
    public ProductDTO searchByName(String name) {
        List<Object[]> result = productRepository.searchByName(name);
        Object[] row = result.get(0);
        String ten = (String) row[0];
        String image = (String) row[1];
        Float price = (Float) row[2];
        ProductDTO productDTO = new ProductDTO(ten, price, image);
        return productDTO;
    }

}
