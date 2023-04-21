package com.AccioBazaar.E.Commerce.RequestDto;

import com.AccioBazaar.E.Commerce.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CardRequestDto {


    private int customerId;
    private String cardNo;

    private int cvv;

    private CardType cardType;


}
