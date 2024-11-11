package com.example.lab9.Daos;

import com.example.lab9.Dtos.CoctelDTO;
import com.example.lab9.Entities.Coctel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoctelDao {

    RestTemplate restTemplate = new RestTemplate();


    public List<Coctel> cocteles(){
        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
        ResponseEntity<CoctelDTO> response = restTemplate.getForEntity(endPoint,CoctelDTO.class);
        return response.getBody().getDrinks().stream().limit(12).collect(Collectors.toList());
    }

    public Coctel getDetalleCoctel(String id){
        String endPoint = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=";
        CoctelDTO response = restTemplate.getForObject(endPoint + id, CoctelDTO.class);
        return response != null && !response.getDrinks().isEmpty() ? response.getDrinks().get(0) : null;
    }

}
