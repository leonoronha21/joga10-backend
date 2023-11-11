package com.project.joga10.demo.dto;


import java.util.List;



import com.project.joga10.demo.entity.Estabelecimentos;
import com.project.joga10.demo.entity.PartidaMembro;
import com.project.joga10.demo.entity.Partidas;
import com.project.joga10.demo.entity.Quadras;

public class PartidaDTO {

    private Partidas partidas;

    private Estabelecimentos local;
 
    private Quadras quadra;
   
    private Quadras preco;
  

    public Quadras getPreco() {
        return preco;
    }
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
    public Object getNomePartida() {
        return null;
    }
}
