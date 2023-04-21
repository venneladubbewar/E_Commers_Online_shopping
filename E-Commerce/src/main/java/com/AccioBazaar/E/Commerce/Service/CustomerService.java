package com.AccioBazaar.E.Commerce.Service;

import com.AccioBazaar.E.Commerce.Convertor.CustomerConvertor;
import com.AccioBazaar.E.Commerce.Model.Cart;
import com.AccioBazaar.E.Commerce.Model.Customer;
import com.AccioBazaar.E.Commerce.Repository.CustomerRepository;
import com.AccioBazaar.E.Commerce.RequestDto.CustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(CustomerRequestDto customerRequestDto) {

        Customer customer = CustomerConvertor.customerRequestDtoToCustomer(customerRequestDto);

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);

       customerRepository.save(customer);

       return "sucess";


    }
}
