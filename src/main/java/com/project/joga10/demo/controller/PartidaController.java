package com.project.joga10.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.joga10.demo.Repository.PartidaRepository;
import com.project.joga10.demo.entity.Partidas;
import com.project.joga10.demo.services.PartidasService;

@RestController
@CrossOrigin
public class PartidaController {
    
    @Autowired
    private PartidasService service;

    @Autowired
    private PartidaRepository partidasRepository;

    public PartidaController(PartidasService service){
        this.service = service;
    }
    
    @PostMapping("/criaPartida")
    private ResponseEntity<String> cadastraCartao(@RequestBody Partidas partidas)
    {
        String msg = service.SavePartidas(partidas);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

    @GetMapping("/listaPartidas")
    public ResponseEntity<List<Partidas>> getAllPartidas() {

        List<Partidas> partidas = partidasRepository.findAll();
        return ResponseEntity.ok(partidas);
    }
}

