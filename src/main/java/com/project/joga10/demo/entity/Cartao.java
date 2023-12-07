package com.project.joga10.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Table(name= "cartao")

public class Cartao {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcartao")
    private Long id;

    private String cpf;
    private String cvc;
    private String bandeira;
    private String numero_cartao;
    private String nome_titular;
    @Column(name = "id_user")
    private Long id_user; 
    private String validade;
    
 
}
