package com.project.joga10.demo.dto;


import java.util.List;



import com.project.joga10.demo.entity.Estabelecimentos;

import com.project.joga10.demo.entity.Partidas;
import com.project.joga10.demo.entity.Quadras;
import com.project.joga10.demo.entity.User;

public class PartidaDTO {

    private Partidas partidas;
 
    private String equipe;

    private Estabelecimentos local;
 
    private Quadras quadra;
   
    private Quadras preco;

    private User userId;
  
    private User nome;

    public Quadras getPreco() {
        return preco;
    }
    private List<PartidaMembroDTO> time1Members;
    private List<PartidaMembroDTO> time2Members;

    public Partidas getPartidas() {
        return partidas;
    }
    public void setPartidas(Partidas partidas) {
        this.partidas = partidas;
    }
    public List<PartidaMembroDTO> getTime1Members() {
        return time1Members;
    }
    public void setTime1Members(List<PartidaMembroDTO> time1Members) {
        this.time1Members = time1Members;
    }
    public List<PartidaMembroDTO> getTime2Members() {
        return time2Members;
    }
    public void setTime2Members(List<PartidaMembroDTO> time2Members) {
        this.time2Members = time2Members;
    }
 public Quadras getQuadra() {
        return quadra;
    }
    public void setQuadra(Quadras quadra) {
        this.quadra = quadra;
    }
      public Estabelecimentos getLocal() {
        return local;
    }
    public void setLocal(Estabelecimentos local) {
        this.local = local;
    }
    public User getIdUser() {
        return userId;
    }
    public String getEquipe() {
        return equipe;
    }
    public User getNome() {
        return nome;
    }
   
}
