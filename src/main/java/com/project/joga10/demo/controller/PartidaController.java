package com.project.joga10.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.joga10.demo.Repository.PartidaMembroRepository;
import com.project.joga10.demo.Repository.PartidaRepository;
import com.project.joga10.demo.dto.PartidaDTO;
import com.project.joga10.demo.entity.PartidaMembro;
import com.project.joga10.demo.entity.Partidas;
import com.project.joga10.demo.services.PartidasService;

@RestController
@CrossOrigin
public class PartidaController {
    
    @Autowired
    private PartidasService service;

    @Autowired
    private PartidaRepository partidasRepository;
     @Autowired
    private PartidaMembroRepository partidaMembroRepository;

    public PartidaController(PartidasService service){
        this.service = service;
    }
    @PostMapping("/criarPartidas")
        private ResponseEntity<String> criaPartida(@RequestBody PartidaDTO partidaDTO) {
            try {
        String msg = service.SavePartidas(partidaDTO);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
             } catch (Exception e) {
       
        e.printStackTrace();
        return new ResponseEntity<String>("Erro durante a criação da partida", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping("/listaPartidas")
    public ResponseEntity<List<Partidas>> getAllPartidas() {

        List<Partidas> partidas = partidasRepository.findAll();
        return ResponseEntity.ok(partidas);
    }

    
        @PostMapping("/partidaPorId")
        public ResponseEntity<Partidas> getPartidaByIdAndUserId(@RequestBody Map<String, String> requestParams) {
            String idPartida = requestParams.get("PartidaID");
            String idUser = requestParams.get("id_user");

            Partidas partida = partidasRepository.findByIdAndUserId(idPartida, idUser);

            List<PartidaMembro> membros = partidaMembroRepository.findMembroByIdPartida(partida);

            partida.setMembros(membros);
        

           return ResponseEntity.ok(partida);
       
    }
    
    @PostMapping("/partidasPorUsuario")
    public ResponseEntity<List<Partidas>> getPartidasByUserId(@RequestBody Map<String, String> requestParams) {
    String idUser = requestParams.get("id_user");

    List<Partidas> partidas = partidasRepository.findbyUserId(idUser);

    // Itera sobre a lista de partidas para buscar membros e configurá-los
    for (Partidas partida : partidas) {
        List<PartidaMembro> membros = partidaMembroRepository.findMembroByIdPartida(partida);
        partida.setMembros(membros);
    }

    return ResponseEntity.ok(partidas);
}
 @PostMapping("/partidasAtivas")
    public ResponseEntity<List<Partidas>> getUltimaPartida(@RequestBody Map<String, String> requestParams) {
    String idUser = requestParams.get("id_user");
    String status = requestParams.get("status");

    List<Partidas> partidas = partidasRepository.findbyUserIdLastCreated(idUser, status);


    for (Partidas partida : partidas) {
        List<PartidaMembro> membros = partidaMembroRepository.findMembroByIdPartida(partida);
        partida.setMembros(membros);
    }

    return ResponseEntity.ok(partidas);
}
        @PutMapping("/finalizaPartida")
        public ResponseEntity<String> finalizarPartida(@RequestBody Partidas partida) {
       Partidas partidaAtualizada = service.updatePartida(partida);

    if (partidaAtualizada != null) {
        return ResponseEntity.ok("Partida finalizada com sucesso!");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Partida não encontrada ou não foi possível finalizar.");
    }
    
    }

}

