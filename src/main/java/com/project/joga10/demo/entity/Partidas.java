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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "partidas")
public class Partidas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PartidaID")
    private long id;

    /*IMPLEMENTAR O TRABALHO DE FKS COMO OBJETOS */
  
    private Long id_estabelecimento;

 
    private Long id_quadra;

  
    private Long user_id;

    private String duracao;
    private String data_hora;
    
    private String status;
    private String preco;
}