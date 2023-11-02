package com.project.joga10.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @JoinColumn(name = "estabelecimento", referencedColumnName = "id")
    private Estabelecimentos id_Estabelecimentos; 

    @ManyToOne  //fk estabelecimento
    @JoinColumn(name = "QuadrasID", referencedColumnName = "id")
    private Quadras id_quadra; 


    private String duracao;
    private String dataHora;
    private String status;
    private String preco;


}
