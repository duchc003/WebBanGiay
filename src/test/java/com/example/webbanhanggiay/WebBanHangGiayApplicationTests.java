package com.example.webbanhanggiay;

import com.example.webbanhanggiay.dto.CartDetailDTO;
import com.example.webbanhanggiay.entity.User;
import com.example.webbanhanggiay.repository.CartDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class WebBanHangGiayApplicationTests {

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void cartDetailDTO() {
        User user = new User();
        user.setName("duchcph22577");
        user.setPassword("congduc003");
        List<Object[]> listObjects = cartDetailRepository.getCartDetail(user);
        for (Object[] x : listObjects) {
            String image = (String) x[0];
            String productName = (String) x[1];
            BigDecimal unitPrice = (BigDecimal) x[2];
            BigDecimal originalPrice = (BigDecimal) x[3];
            Integer quantity = (Integer) x[4];

            // Tiếp tục xử lý thông tin sản phẩm
            System.out.println("Image: " + image);
            System.out.println("Product Name: " + productName);
            System.out.println("Unit Price: " + unitPrice);
            System.out.println("Original Price: " + originalPrice);
            System.out.println("Quantity: " + quantity);
        }
    }

}
