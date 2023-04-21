package com.AccioBazaar.E.Commerce.ResponseDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CardResponseDto {

    private String name;

 List<CardDto> cardDtos;



}
