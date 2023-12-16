package com.project.joga10.demo.services;

import com.project.joga10.demo.Repository.PartidaMembroRepository;
import com.project.joga10.demo.entity.PartidaMembro;
import com.project.joga10.demo.entity.Partidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PartidaMembroService {

    @Autowired
    private PartidaMembroRepository partidaMembroRepository;

     @Transactional
    public PartidaMembro adicionarMembroPartida(Partidas idPartida, Long idUser, String nome, String equipe) {
        
        PartidaMembro partidaMembro = new PartidaMembro();
    
        partidaMembro.setPartida(idPartida);
        partidaMembro.setIdUser(idUser);
         partidaMembro.setNome(nome);
            partidaMembro.setEquipe(equipe);
       
        return partidaMembroRepository.save(partidaMembro);
    }
   
}
