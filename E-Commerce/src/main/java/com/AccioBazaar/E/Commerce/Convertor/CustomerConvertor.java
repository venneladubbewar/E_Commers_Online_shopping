package com.AccioBazaar.E.Commerce.Convertor;


import com.AccioBazaar.E.Commerce.Model.Customer;
import com.AccioBazaar.E.Commerce.RequestDto.CustomerRequestDto;

public class CustomerConvertor {

    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto) {

           return Customer.builder()
                   .name(customerRequestDto.getName())
                   .age(customerRequestDto.getAge())
                   .email(customerRequestDto.getEmail())
                   .mobNo(customerRequestDto.getMobNo())
                   .build();

    }
}
