package com.AccioBazaar.E.Commerce.Controller;


import com.AccioBazaar.E.Commerce.RequestDto.CustomerRequestDto;
import com.AccioBazaar.E.Commerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
          return customerService.addCustomer(customerRequestDto);

    }


}
