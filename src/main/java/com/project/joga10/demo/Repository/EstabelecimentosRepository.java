package com.project.joga10.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.joga10.demo.entity.Estabelecimentos;



@Repository
public interface EstabelecimentosRepository extends JpaRepository <Estabelecimentos, Long> {

    
    
}
