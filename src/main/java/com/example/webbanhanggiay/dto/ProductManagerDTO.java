package com.example.webbanhanggiay.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductManagerDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Color is required")
    private String color;

    @NotNull(message = "Size is required")
    private Integer size;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Origin is required")
    private String origin;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private Float price;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Image is required")
    private String image;
}
