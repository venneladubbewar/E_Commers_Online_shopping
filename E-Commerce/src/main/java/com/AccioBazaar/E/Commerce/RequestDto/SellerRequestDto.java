package com.AccioBazaar.E.Commerce.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SellerRequestDto {

    private String name;

    private String mobNo;

    private String email;

    private String panNo;

}
