package com.example.lab9.Dtos;

import com.example.lab9.Entities.Coctel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CoctelDTO {
    private List<Coctel> drinks;
}
