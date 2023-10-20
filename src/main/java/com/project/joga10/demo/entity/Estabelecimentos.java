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
@Table(name= "estabelecimentos")
public class Estabelecimentos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstabelecimento")
    private Long id;

    private String nome;
    private String endereco;
    private String telefone;
    private String hora_abertura;
    private String hora_fechamento;
    private String email;
    private String cnpj;
 

}
