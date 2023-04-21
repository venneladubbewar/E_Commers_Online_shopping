package com.AccioBazaar.E.Commerce.ResponseDto;

import com.AccioBazaar.E.Commerce.Enum.ProductStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductResponseDto {

    private String name;

    private int price;

    private int quantity;

    private ProductStatus productStatus;


}
