package com.project.joga10.demo.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.Security.HashPassword;
import com.project.joga10.demo.Repository.UserRepo;
import com.project.joga10.demo.entity.User;
import com.project.joga10.demo.security.JwtTokenProvider;

@Service
@Component
public class UserService {
    
    @Autowired
    private final  UserRepo userRepo;
     @Autowired
    private JwtTokenProvider jwtTokenProvider;


  
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    
    public String saveUser(User user){
        
        String hashedPassword = HashPassword.hashPassword(user.getPassword());
    
    if (hashedPassword != null) {
        user.setPassword(hashedPassword);
        userRepo.save(user);
        return "Cadastrado com Sucesso!";
    } else {
        // Lida com o caso em que a senha não pôde ser criptografada
        return "Erro ao cadastrar usuário.";
    }

    }

    
    public boolean isValidUser(String email, String password) {
      
        UserDetails user = userRepo.findByEmail(email);

        if (user != null) {
            String storedPassword = user.getPassword();
            return HashPassword.checkPassword(password, storedPassword);
        } else {
            return false;
        }
    }

    public UserDetails getUserByEmail(String email) {
  
        UserDetails user = userRepo.findByEmail(email);
    
        return user; 
    }

    public User updateUser(User user) {

        UserDetails existingUser = userRepo.findByEmail(user.getEmail());
    
        if (existingUser != null) {
          
            ((User) existingUser).setPrimeiroNome(user.getPrimeiroNome());
            ((User) existingUser).setSegundoNome(user.getSegundoNome()); //sobrenome
           ((User) existingUser).setEmail(user.getEmail());
           ((User) existingUser).setCidade(user.getCidade());
           ((User) existingUser).setComplemento(user.getComplemento());
            ((User) existingUser).setRua(user.getRua());
            ((User) existingUser).setBairro(user.getBairro());
            ((User) existingUser).setContato(user.getContato());


            
            userRepo.save(((User) existingUser));
    
            return ((User) existingUser);
        } else {
         
            return null;
        }
    }
    public String generateToken(UserDetails userDetails) {
        return jwtTokenProvider.generateToken(userDetails);
    }
}
