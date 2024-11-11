package com.example.lab9.Entities;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="coctelFav")
public class CoctelFav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcoctelFav", nullable = false)
    private Integer id;

    @Column(name="nombre", nullable = false)
    private String name;

    @Column(name="thumbnail", nullable = false)
    private String thumbnail;

    @Column(name="esFav", nullable = false)
    private boolean esFav;


}
