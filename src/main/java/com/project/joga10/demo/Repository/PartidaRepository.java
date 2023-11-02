package com.project.joga10.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.joga10.demo.entity.Partidas;


@Repository
public interface PartidaRepository extends JpaRepository<Partidas, Long> {
    
}
