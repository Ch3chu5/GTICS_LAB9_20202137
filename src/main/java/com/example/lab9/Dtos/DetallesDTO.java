package com.example.lab9.Dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DetallesDTO {
    private List<String> strIngedients;
    private List<String> strMeasures;
    private String strDrink;
    private String strThumb;
    private String strCateogry;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;
}
