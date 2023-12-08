package com.project.joga10.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.joga10.demo.Repository.QuadraRepository;
import com.project.joga10.demo.entity.Quadras;

@RestController
@CrossOrigin
public class QuadrasController {
   
    @Autowired
    private  QuadraRepository quadraRepository;

      @GetMapping("/quadras")
    public ResponseEntity<List<Quadras>> getAllQuadras() {
        List<Quadras> quadras = quadraRepository.findAll();
        return ResponseEntity.ok(quadras);
    }
}
