package com.project.joga10.demo.repo;
import com.project.joga10.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User, String> {

    User findByEmail(String email);
    
}
