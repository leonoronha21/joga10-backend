package com.project.joga10.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.joga10.demo.dto.LoginDTO;
import com.project.joga10.demo.entity.User;
import com.project.joga10.demo.services.UserService;

@RestController
@CrossOrigin

public class UserController {
    @Autowired
    private UserService service;

  
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/cadastroUsuario")
    private ResponseEntity<String> registerUser(@RequestBody User user){

            String msg = service.saveUser(user);
            
            return new ResponseEntity<String>(msg, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO) {
        
        if (service.isValidUser(loginDTO.getEmail(), loginDTO.getPassword())) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
        
    }
}

