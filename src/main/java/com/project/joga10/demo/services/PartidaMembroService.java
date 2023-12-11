package com.project.joga10.demo.services;

import com.project.joga10.demo.Repository.PartidaMembroRepository;
import com.project.joga10.demo.Repository.PartidaRepository;
import com.project.joga10.demo.entity.PartidaMembro;
import com.project.joga10.demo.entity.Partidas;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PartidaMembroService {

    @Autowired
    private PartidaMembroRepository partidaMembroRepository;

     @Autowired
    private PartidaRepository partidaRepository;

 @Transactional
    public PartidaMembro adicionarMembroPartida(Partidas idPartida, Long idUser) {
        
        PartidaMembro partidaMembro = new PartidaMembro();
    
        partidaMembro.setPartida(idPartida);
        partidaMembro.setIdUser(idUser);
       
        return partidaMembroRepository.save(partidaMembro);
    }
}
