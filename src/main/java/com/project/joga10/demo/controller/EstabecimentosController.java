package com.project.joga10.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.project.joga10.demo.entity.Estabelecimentos;
import com.project.joga10.demo.services.EstabelecimentosService;


@RestController
@CrossOrigin

public class EstabecimentosController{
    @Autowired
    private  EstabelecimentosService service;

  
    public EstabecimentosController(EstabelecimentosService service) {
        this.service = service;
    }
    

    @PostMapping("/cadastroEstabelecimento")
    private ResponseEntity<String> registerUser(@RequestBody Estabelecimentos estabelecimentos){

    String msg = service.saveEstabelecimento(estabelecimentos);
    
    return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

}