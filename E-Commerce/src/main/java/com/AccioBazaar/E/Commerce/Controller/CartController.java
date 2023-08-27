package com.AccioBazaar.E.Commerce.Controller;

import com.AccioBazaar.E.Commerce.RequestDto.OrderRequestDto;
import com.AccioBazaar.E.Commerce.ResponseDto.OrderResponseDto;
import com.AccioBazaar.E.Commerce.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/addtocart")
    public String addItemToCart(@RequestBody OrderRequestDto orderRequestDto) throws Exception {
        try{
            cartService.addItemTocart(orderRequestDto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return "success";
    }

    @PostMapping("/checkout/{customerId}")
    public ResponseEntity checkout(@PathVariable("customerId") int customerId){
        List<OrderResponseDto> orderResponseDtos ;
        try{
           orderResponseDtos = cartService.checkout(customerId);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(orderResponseDtos,HttpStatus.ACCEPTED);
    }

}
