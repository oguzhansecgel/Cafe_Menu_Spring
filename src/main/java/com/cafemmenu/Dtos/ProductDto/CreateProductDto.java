package com.cafemmenu.Dtos.ProductDto;

import lombok.Data;

@Data
public class CreateProductDto {
    private String productName;
    private String productDescription;
    private Double price;
    private Long categoryId;
}
