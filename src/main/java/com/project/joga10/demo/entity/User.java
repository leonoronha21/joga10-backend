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
@Table(name= "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long id;

    private String PrimeiroNome;
    private String SegundoNome;
    @Column(unique = true)
    private String email;
    private String Password;
    private String cidade;
    private String complemento;
    private String rua;
    private String bairro;
    private String contato;

    public Long getId() {
        return id;
    }

}
