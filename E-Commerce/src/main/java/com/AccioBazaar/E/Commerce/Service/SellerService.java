package com.AccioBazaar.E.Commerce.Service;

import com.AccioBazaar.E.Commerce.Controller.SellerController;
import com.AccioBazaar.E.Commerce.Convertor.SellerConvertor;
import com.AccioBazaar.E.Commerce.Model.Seller;
import com.AccioBazaar.E.Commerce.Repository.SellerRepository;
import com.AccioBazaar.E.Commerce.RequestDto.SellerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public String  addSeller(SellerRequestDto sellerRequestDto) {

       Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);

       sellerRepository.save(seller);

       return "Congrats! Now you can sell on AccioBazaar";


    }
}
