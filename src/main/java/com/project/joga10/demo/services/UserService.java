package com.project.joga10.demo.services;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.project.joga10.demo.repo.UserRepo;
import com.project.joga10.demo.entity.User;

@Service
@Component
public class UserService {
    
    private final  UserRepo userRepo;

  
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public String saveUser(User user){
        
        userRepo.save(user);
        return "Cadastrado com Sucesso!";

    }


    public boolean isValidUser(String email, String password) {
        // Implemente a lógica para verificar as credenciais do usuário
        User user = userRepo.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return true; // Credenciais válidas
        } else {
            return false; // Credenciais inválidas
        }
    }
    
}
