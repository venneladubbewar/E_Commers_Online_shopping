package com.AccioBazaar.E.Commerce.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CustomerRequestDto {
    private String name ;

    private String email;

    private String mobNo;

    private int age;
}
