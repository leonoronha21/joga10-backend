package com.project.joga10.demo.Repository;
import com.project.joga10.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
    
}
