package com.project.joga10.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.joga10.demo.entity.Partidas;


@Repository
public interface PartidaRepository extends JpaRepository<Partidas, Long> {
 
    @Query("SELECT p FROM Partidas p WHERE p.id = :idPartida AND p.user_id = :idUser")
    Partidas findByIdAndUserId(@Param("idPartida") String idPartida, @Param("idUser") String idUser);
}
