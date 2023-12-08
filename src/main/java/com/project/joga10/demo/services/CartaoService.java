package com.project.joga10.demo.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.joga10.demo.Repository.CartaoRepository;
import com.project.joga10.demo.entity.Cartao;

@Service
@Component
public class CartaoService {
    private final CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository cartaoRepository){
        this.cartaoRepository = cartaoRepository;
    }



    public String saveCartao(Cartao cartao){
        cartaoRepository.save(cartao);
        return "Cadastrado com sucesso!";
    }
    
     public List<Cartao> getCartaoById(String idUser) {
  
       List <Cartao> cartao = cartaoRepository.findByIdUser(idUser);
    
        return cartao; 
    }
}
