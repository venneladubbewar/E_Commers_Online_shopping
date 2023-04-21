package com.AccioBazaar.E.Commerce.RequestDto;

import com.AccioBazaar.E.Commerce.Enum.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ProductRequestDto {

    private int sellerId;
    private String productName;

    private int price;

    private int quantity;

    private ProductCategory productCategory;
}
