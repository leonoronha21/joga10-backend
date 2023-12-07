package com.project.joga10.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.joga10.demo.entity.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository <Cartao, Long>{

    @Query("SELECT c FROM Cartao c WHERE c.id_user = :idUser")
    List<Cartao> findByIdUser(@Param("idUser") String idUser);

}
