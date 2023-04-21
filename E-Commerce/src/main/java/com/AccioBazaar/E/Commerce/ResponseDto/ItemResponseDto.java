package com.AccioBazaar.E.Commerce.ResponseDto;

import com.AccioBazaar.E.Commerce.Enum.ProductCategory;
import com.AccioBazaar.E.Commerce.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class ItemResponseDto {
      private String productName;

      private int price;

      private ProductCategory productCategory;

      private ProductStatus productStatus;


}
