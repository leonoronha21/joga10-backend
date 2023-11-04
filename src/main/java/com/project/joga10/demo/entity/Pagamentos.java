package com.project.joga10.demo.entity;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data//para metodo getter and setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Table(name= "Pagamentos")
public class Pagamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PagamentoID")
    private Long id;

    private String PartidaID;
    private String UserID;
    private String Valor;
    private String StatusPagamento;
    private String DataHoraPagamento;
   
}

