package com.project.joga10.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name="PartidaMembro")
public class PartidaMembro {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "PartidaID", nullable = false)
  @JsonBackReference
  private Partidas partida;
  
  
  @Column(name = "id_user")
  private Long id_user; 

  @Column(name = "equipe")
  private String equipe;


  @Column(name = "nome")
  private String nome;

  public Long getId() {
    return id;
  }

  public Partidas getPartida() {
    return partida;
  }

  public Long getId_user() {
    return id_user;
  }

  public String getEquipe() {
    return equipe;
  }

  public String getNome() {
    return nome;
  }

  public void setPartida(Partidas partidas) {
    this.partida = partidas;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setIdUser(Long user) { 
    this.id_user = user;
  }

  public void setEquipe(String equipe) {
    this.equipe = equipe;
  }

 


}
