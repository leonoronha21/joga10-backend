package com.project.joga10.demo.dto;

import com.project.joga10.demo.entity.User;

public class LoginDTO extends User {
    private String email;
    private String password;
      
    
    // getters e setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

 
}