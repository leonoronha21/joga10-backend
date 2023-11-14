package com.project.joga10.demo.dto;

import java.util.List;

import com.project.joga10.demo.entity.PartidaMembro;
import com.project.joga10.demo.entity.Partidas;

public class PartidaMembroDTO {
    private Partidas partidas;
    private Long id_user; 
   
    private String nome; 
    private String equipe;
    
    
    
    private List<PartidaMembro> time1Members;
    private List<PartidaMembro> time2Members;


    public Partidas getPartidas() {
        return partidas;
    }
    public void setPartidas(Partidas partidas) {
        this.partidas = partidas;
    }
    public List<PartidaMembro> getTime1Members() {
        return time1Members;
    }
    public void setTime1Members(List<PartidaMembro> time1Members) {
        this.time1Members = time1Members;
    }
    public List<PartidaMembro> getTime2Members() {
        return time2Members;
    }
    public void setTime2Members(List<PartidaMembro> time2Members) {
        this.time2Members = time2Members;
    }     
   
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEquipe() {
        return equipe;
    }
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
     public Long getId_user() {
        return id_user;
    }
    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
}
