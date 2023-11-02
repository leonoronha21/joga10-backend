package com.project.joga10.demo.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//para metodo getter and setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "partidas")
public class Partidas {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PartidaID")
    private long id;

    @ManyToOne  //fk estabelecimento
    @JoinColumn(name = "Estabelecimento", referencedColumnName = "id")
    private Estabelecimentos id_estabelecimento; 

    @ManyToOne  //fk estabelecimento
    @JoinColumn(name = "Quadras", referencedColumnName = "id")
    private Estabelecimentos QuadraID; 


    private String duracao;
    private String dataHora;
    private String status;
    private String preco;


}
