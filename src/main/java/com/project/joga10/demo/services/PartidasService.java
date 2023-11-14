package com.project.joga10.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.joga10.demo.Repository.PartidaMembroRepository;
import com.project.joga10.demo.Repository.PartidaRepository;
import com.project.joga10.demo.dto.PartidaDTO;
import com.project.joga10.demo.dto.PartidaMembroDTO;
import com.project.joga10.demo.entity.PartidaMembro;
import com.project.joga10.demo.entity.Partidas;




@Service
@Component
public class PartidasService {
    
    private final PartidaRepository partidasRepository;
    private final PartidaMembroRepository partidasMembroRepository;

    public PartidasService(PartidaRepository partidas, PartidaMembroRepository partidasMembroRepository) {
        this.partidasRepository = partidas;
        this.partidasMembroRepository = partidasMembroRepository;
    }

    public String SavePartidas(PartidaDTO partidaDTO){
        Partidas partidas = partidaDTO.getPartidas();
    
        List<PartidaMembroDTO> allMembersDTO = new ArrayList<>();
        if (partidaDTO.getTime1Members() != null) {
            allMembersDTO.addAll(partidaDTO.getTime1Members());
        }
        if (partidaDTO.getTime2Members() != null) {
            allMembersDTO.addAll(partidaDTO.getTime2Members());
        }
    
        partidasRepository.save(partidas);
    
        for (PartidaMembroDTO membroDTO : allMembersDTO) {

            PartidaMembro membro = new PartidaMembro();        

            membro.setPartida(partidas);
            membro.setIdUser(membroDTO.getId_user());
            membro.setEquipe(membroDTO.getEquipe());
            membro.setNome(membroDTO.getNome());
    
            
            partidasMembroRepository.save(membro);
        }
    
        return "Partida criada!";
    }
    

}
