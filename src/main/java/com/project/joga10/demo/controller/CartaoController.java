package com.project.joga10.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.joga10.demo.entity.Cartao;
import com.project.joga10.demo.services.CartaoService;

@RestController
@CrossOrigin

public class CartaoController {

    @Autowired
    private CartaoService service;

    public CartaoController(CartaoService service){
        this.service = service;
    }
    
    @PostMapping("/cadastraCartao")
    private ResponseEntity<String> cadastraCartao(@RequestBody Cartao cartao)
    {
        String msg = service.saveCartao(cartao);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
