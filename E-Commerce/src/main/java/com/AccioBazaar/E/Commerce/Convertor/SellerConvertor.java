package com.AccioBazaar.E.Commerce.Convertor;

import com.AccioBazaar.E.Commerce.Model.Seller;
import com.AccioBazaar.E.Commerce.RequestDto.SellerRequestDto;
import lombok.experimental.UtilityClass;


public class SellerConvertor {
    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto) {

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .mobNo(sellerRequestDto.getMobNo())
                .email(sellerRequestDto.getEmail())
                .panNo(sellerRequestDto.getPanNo())
                .build();



    }
}


