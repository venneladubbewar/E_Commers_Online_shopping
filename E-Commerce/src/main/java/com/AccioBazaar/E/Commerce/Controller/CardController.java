package com.AccioBazaar.E.Commerce.Controller;

import com.AccioBazaar.E.Commerce.Exception.CustomerNotFoundException;
import com.AccioBazaar.E.Commerce.RequestDto.CardRequestDto;
import com.AccioBazaar.E.Commerce.ResponseDto.CardResponseDto;
import com.AccioBazaar.E.Commerce.Service.CardService;
import com.AccioBazaar.E.Commerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.CacheResponse;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto) {
        CardResponseDto cardResponseDto;
        try{
            cardResponseDto=cardService.addCard(cardRequestDto);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cardResponseDto,HttpStatus.ACCEPTED);
    }

//    @PostMapping("/add")
//    public CardResponseDto addCard(@RequestBody CardRequestDto cardRequestDto) throws CustomerNotFoundException {
//        try{
//            return cardService.addCard(cardRequestDto);
//        }catch(CustomerNotFoundException e){
//            throw new CustomerNotFoundException(e.getMessage());
//        }


    }