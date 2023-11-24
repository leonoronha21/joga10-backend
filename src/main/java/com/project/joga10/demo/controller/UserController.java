package com.project.joga10.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.joga10.demo.Repository.UserRepo;
import com.project.joga10.demo.dto.LoginDTO;

import com.project.joga10.demo.entity.User;
import com.project.joga10.demo.security.JwtTokenProvider;
import com.project.joga10.demo.services.UserService;



@RestController
@CrossOrigin

public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserRepo userRepository;
       @Autowired
    private JwtTokenProvider jwtTokenProvider;

  
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/cadastroUsuario")
    private ResponseEntity<String> registerUser(@RequestBody User user){
        
            String msg = service.saveUser(user);
            
            return new ResponseEntity<String>(msg, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO)  {
        
           
        if (service.isValidUser(loginDTO.getEmail(), loginDTO.getPassword())) {
            UserDetails userDetails = service.getUserByEmail(loginDTO.getEmail());
            String token = jwtTokenProvider.generateToken(userDetails);
            return ResponseEntity.ok("Logado com sucesso! Token:"+token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
     
        
    }

    /* Requisição:  http://192.168.10.104:8080/consultaUsuario?email=leonoronha.andrade@gmail.com  */

    @GetMapping("/consultaUsuario")
    public ResponseEntity<UserDetails> getUserByEmail(@RequestParam String email) {
        UserDetails user = service.getUserByEmail(email);
    
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/lista-usuarios")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    //UPDATE DO USUÁRIO

    @PutMapping("/atualizaUsuario")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
    User updatedUser = service.updateUser(user);

    if (updatedUser != null) {
        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado ou não foi possível atualizar.");
    }
}
   
}

