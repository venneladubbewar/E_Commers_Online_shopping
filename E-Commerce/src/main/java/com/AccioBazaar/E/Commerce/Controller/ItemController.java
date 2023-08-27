package com.AccioBazaar.E.Commerce.Controller;

import com.AccioBazaar.E.Commerce.Exception.ProductNotFoundException;
import com.AccioBazaar.E.Commerce.Repository.ItemRepository;
import com.AccioBazaar.E.Commerce.ResponseDto.ItemResponseDto;
import com.AccioBazaar.E.Commerce.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

     @Autowired
     ItemService itemService;
     @Autowired
     ItemRepository itemRepository;

     @GetMapping("/view/{productId}")
     public ResponseEntity viewItem(@PathVariable ("productId") int productId) {

          ItemResponseDto itemResponseDto;
          try {
               itemResponseDto= itemService.viewItem(productId);
          } catch (ProductNotFoundException e) {
               return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
          }
          return new ResponseEntity(itemResponseDto,HttpStatus.ACCEPTED);
     }
}

