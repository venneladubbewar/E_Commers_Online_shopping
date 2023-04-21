package com.AccioBazaar.E.Commerce.Convertor;

import com.AccioBazaar.E.Commerce.Enum.ProductStatus;
import com.AccioBazaar.E.Commerce.Model.Product;
import com.AccioBazaar.E.Commerce.RequestDto.ProductRequestDto;
import com.AccioBazaar.E.Commerce.ResponseDto.ProductResponseDto;

public class ProductConvertor {

     public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto) {

         return Product.builder()
                 .productName(productRequestDto.getProductName())
                 .price(productRequestDto.getPrice())
                 .quantity(productRequestDto.getQuantity())
                 .productCategory(productRequestDto.getProductCategory())
                 .productStatus(ProductStatus.AVAILABLE)
                 .build();

     }

     public static ProductResponseDto productToProductResponseDto(Product product) {

          return
                  ProductResponseDto.builder()
                          .name(product.getProductName())
                          .price(product.getPrice())
                          .productStatus(product.getProductStatus())
                          .quantity(product.getQuantity())
                          .build();


     }

}
