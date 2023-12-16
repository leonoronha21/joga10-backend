package com.project.joga10.demo.controller;

import com.project.joga10.demo.entity.PartidaMembro;
import com.project.joga10.demo.entity.Partidas;
import com.project.joga10.demo.services.PartidaMembroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PartidaMembroController {

    @Autowired
    private PartidaMembroService partidaMembroService;

    

    @PostMapping("/adicionaMembro")
    public PartidaMembro adicionarMembroPartida(
            @RequestParam Partidas idPartida,
            @RequestParam long idUser,  @RequestParam String nome,  @RequestParam String equipe) {

        return partidaMembroService.adicionarMembroPartida(idPartida, idUser, nome, equipe);
    }
}
