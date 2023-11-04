package com.project.joga10.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.project.joga10.demo.Repository.PartidaRepository;
import com.project.joga10.demo.entity.Partidas;



@Service
@Component
public class PartidasService {
    
    private final PartidaRepository partidasRepository;

   public PartidasService(PartidaRepository partidas) {
        this.partidasRepository = partidas;
    }
    
    
    
    public String SavePartidas(Partidas partidas){
        
        
        partidasRepository.save(partidas);

        return "Partida criada!";
    }


}
