package com.AccioBazaar.E.Commerce.Service;

import com.AccioBazaar.E.Commerce.Exception.CustomerNotFoundException;
import com.AccioBazaar.E.Commerce.Model.Card;
import com.AccioBazaar.E.Commerce.Model.Customer;
import com.AccioBazaar.E.Commerce.Repository.CustomerRepository;
import com.AccioBazaar.E.Commerce.RequestDto.CardRequestDto;
import com.AccioBazaar.E.Commerce.ResponseDto.CardDto;
import com.AccioBazaar.E.Commerce.ResponseDto.CardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

    Customer customer;

    try{
        customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();

    } catch (Exception e) {
        throw new CustomerNotFoundException("Invalid customer id");
        }

     Card card = Card.builder()
             .cardNo(cardRequestDto.getCardNo())
             .cvv(cardRequestDto.getCvv())
             .cardType(cardRequestDto.getCardType())
             .customer(customer)
             .build();

    customer.getCards().add(card);

    customerRepository.save(customer);

       CardResponseDto cardResponseDto = new CardResponseDto();
       cardResponseDto.setName(customer.getName());

       //convert every card to cardDto
        List<CardDto> cardDtoList = new ArrayList<>();
        for(Card card1: customer.getCards()) {
            CardDto cardDto = new CardDto();
            cardDto.setCardNo(card1.getCardNo());
            cardDto.setCardType(card1.getCardType());
            cardDtoList.add(cardDto);

        }

        cardResponseDto.setCardDtos(cardDtoList);

        return cardResponseDto;



    }
}


