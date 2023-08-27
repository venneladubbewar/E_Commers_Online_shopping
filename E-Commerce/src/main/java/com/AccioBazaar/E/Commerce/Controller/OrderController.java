package com.AccioBazaar.E.Commerce.Controller;

import com.AccioBazaar.E.Commerce.Exception.CustomerNotFoundException;
import com.AccioBazaar.E.Commerce.Exception.InsufficientQuantityException;
import com.AccioBazaar.E.Commerce.Exception.ProductNotFoundException;
import com.AccioBazaar.E.Commerce.RequestDto.OrderRequestDto;
import com.AccioBazaar.E.Commerce.ResponseDto.OrderResponseDto;
import com.AccioBazaar.E.Commerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

      @Autowired
      OrderService orderService;

      @PostMapping("/place")
      public ResponseEntity addOrder(@RequestBody OrderRequestDto orderRequestDto) {
           OrderResponseDto orderResponseDto;
            try{
                  orderResponseDto= orderService.addOrder(orderRequestDto);
            }catch (Exception e){
                  return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(orderResponseDto,HttpStatus.ACCEPTED);

      }


}
