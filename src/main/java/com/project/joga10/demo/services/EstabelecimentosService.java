package com.project.joga10.demo.services;




import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.project.joga10.demo.repo.EstabelecimentosRepository;
import com.project.joga10.demo.entity.Estabelecimentos;





@Service
@Component
public class EstabelecimentosService {

    private final  EstabelecimentosRepository estabelecimentoRepository;


   public EstabelecimentosService(EstabelecimentosRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }
   
    public String saveEstabelecimento(Estabelecimentos estabelecimentos) {
         estabelecimentoRepository.save(estabelecimentos); 
        return "Cadastrado com Sucesso!";
    }

      
    }

