package com.AccioBazaar.E.Commerce.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderRequestDto {
    private  int customerId;
    private  int productId;
    private int quantity;
}
