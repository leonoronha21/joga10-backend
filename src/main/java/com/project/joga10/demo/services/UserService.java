package com.project.joga10.demo.services;




import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.joga10.demo.Repository.UserRepo;
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
      
        User user = userRepo.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public User getUserByEmail(String email) {
  
        User user = userRepo.findByEmail(email);
    
        return user; 
    }

    public User updateUser(User user) {

        User existingUser = userRepo.findByEmail(user.getEmail());
    
        if (existingUser != null) {
          
            existingUser.setPrimeiroNome(user.getPrimeiroNome());
            existingUser.setSegundoNome(user.getSegundoNome()); //sobrenome
            existingUser.setEmail(user.getEmail());
            existingUser.setCidade(user.getCidade());
            existingUser.setComplemento(user.getComplemento());
            existingUser.setRua(user.getRua());
            existingUser.setBairro(user.getBairro());
            existingUser.setContato(user.getContato());


            
            userRepo.save(existingUser);
    
            return existingUser;
        } else {
         
            return null;
        }
    }
}
