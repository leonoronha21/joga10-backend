package com.project.joga10.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.joga10.demo.entity.PartidaMembro;
import com.project.joga10.demo.entity.Partidas;




public interface PartidaMembroRepository extends JpaRepository<PartidaMembro, Long> {
 
    @Query("SELECT p FROM PartidaMembro p WHERE p.partida = :partida")
    List<PartidaMembro> findMembroByIdPartida(@Param("partida") Partidas partida);
}

