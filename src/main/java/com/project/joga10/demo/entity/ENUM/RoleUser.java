package com.project.joga10.demo.entity.ENUM;

public enum RoleUser {
    

    user("user");

    private String role;

   RoleUser(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    
}
