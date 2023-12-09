package com.project.joga10.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.joga10.demo.entity.Partidas;


@Repository
public interface PartidaRepository extends JpaRepository<Partidas, Long> {
 
    @Query("SELECT p FROM Partidas p WHERE p.id = :idPartida AND p.user_id = :idUser")
    Partidas findByIdAndUserId(@Param("idPartida") String idPartida, @Param("idUser") String idUser);
    
    @Query("SELECT p FROM Partidas p WHERE p.user_id = :idUser order by p.id desc")
    List<Partidas> findbyUserId( @Param("idUser")String user);

    @Query("SELECT p FROM Partidas p WHERE p.user_id = :idUser AND p.status = :status order by p.id desc")
    List<Partidas> findbyUserIdLastCreated( @Param("idUser")String user,@Param("status") String status);

    Optional<Partidas> findById(int id);
}

