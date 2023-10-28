package com.project.joga10.demo.entity;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//para metodo getter and setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "estabelecimentos")
public class Estabelecimentos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Estabelecimento")
    private Long id;

    /* /* cnpjController 
                  nomeFantasiaController
                  razaoSocialController 
                  cidadeController 
                  cepController
                  ruaController
                  bairroController
                  numeroController
                  telefoneController
                  emailController 
                  horaAberturaController
                  horaFechamentoController  */
    private String cnpj;
    private String nome;
    private String razao_social;
    private String cidade;
    private String cep;
    private String rua;
    private String bairro;
    private String numero;
    private String hora_abertura;
    private String hora_fechamento;
    private String telefone;
   
    private String email;
    private Integer status = 0;
 

}
