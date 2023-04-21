package com.AccioBazaar.E.Commerce.Controller;

import com.AccioBazaar.E.Commerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

      @Autowired
    OrderService orderService;

      //public


}
