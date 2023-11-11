package com.project.joga10.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PartidaMembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PartidaID")
    private long id;

    /*IMPLEMENTAR O TRABALHO DE FKS COMO OBJETOS */
  //FK
    //FK

}
