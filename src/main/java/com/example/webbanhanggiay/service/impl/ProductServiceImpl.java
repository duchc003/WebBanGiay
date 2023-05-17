package com.example.webbanhanggiay.service.impl;

import com.example.webbanhanggiay.dto.ProductDTO;
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

        for (Object[] reObjects : results
        ) {
            String name = (String) reObjects[0];
            String image = (String) reObjects[1];
            Float price = (Float) reObjects[2];

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
        Pageable pageable = PageRequest.of(pageNo, pageSize);//Pageable sẽ chứa các thông tin phân trang như số phần tử được lấy, vị trí trang được lấy
        Page<Object[]> pageObjects = productRepository.findAllPage(pageable);//Page sẽ chứa kết quả trả về (gồm số phần tử, danh sách các phần tử)
        List<Object[]> listObjects = pageObjects.getContent();
        List<ProductDTO> productDTOList = listObjects.stream()
                .map(objects -> new ProductDTO((String) objects[0], (Float) objects[1], (String) objects[2]))
                .collect(Collectors.toList());
        return new PageImpl<>(productDTOList, pageable, pageObjects.getTotalElements());
    }
}
