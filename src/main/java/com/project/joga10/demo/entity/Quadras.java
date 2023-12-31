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


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quadras")
public class Quadras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quadra")
    private long id;

 
    private Long id_estabelecimento; 

    private String nome;
    @Column(name = "tipo_quadra")
    private String TipoQuadra;
    @Column(name = "preco")
    private String preco;
}
