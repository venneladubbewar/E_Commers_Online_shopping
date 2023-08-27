package com.AccioBazaar.E.Commerce.ResponseDto;

import com.AccioBazaar.E.Commerce.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderResponseDto {

    private Date orderDate;
    private String itemName;
    private  int quantity;
    private int itemCost;
    private int deliveryCost;
    private int totalCost;
    private String cardUsedForPayment;






}
