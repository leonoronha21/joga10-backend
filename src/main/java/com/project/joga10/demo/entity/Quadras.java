package com.project.joga10.demo.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "quadras")
public class Quadras {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuadraID")

    private long id;


    private long idEstabelecimento;
    private String nome;
    private String TipoQuadra;
    private String TaxaHora;
    
}
