package com.project.joga10.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

      @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
         httpSecurity
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(HttpMethod.POST, "/login").permitAll()
        .requestMatchers(HttpMethod.PUT, "/atualizaUsuario").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/cadastraCartao").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/cadastroEstabelecimento").permitAll()
         .requestMatchers(HttpMethod.POST, "/cadastroUsuario").permitAll()
          .requestMatchers(HttpMethod.GET, "/consultaUsuario").hasRole("user")
           .requestMatchers(HttpMethod.POST, "/criarPartidas").hasRole("user"))
            .requestMatchers(HttpMethod.GET, "/lista-usuarios").hasRole("user")
             .requestMatchers(HttpMethod.GET, "/lista-partidas").hasRole("user")
              .requestMatchers(HttpMethod.POST, "/partidaPorId").hasRole("user")
               .requestMatchers(HttpMethod.POST, "/partidasPorUsuario").hasRole("user")
               .requestMatchers(HttpMethod.POST, "/partidasAtivas").hasRole("user")
                 .requestMatchers(HttpMethod.GET, "/estabelecimentos").hasRole("user")
                .requestMatchers(HttpMethod.POST, "/cartaoUserId").hasRole("user")
                .requestMatchers(HttpMethod.GET, "/listaCartoesUser").hasRole("user")
                .requestMatchers(HttpMethod.GET, "/quadras").hasRole("user")
            .requestMatchers(HttpMethod.PUT, "/finalizaPartida").hasRole("user")
                 .requestMatchers(HttpMethod.POST, "/adicionaMembro").hasRole("user")
                .anyRequest().authenticated()
          
               
                
        ) //.authenticationProvider(authenticationProvider);
               .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);       
        return httpSecurity.build();
    }
  
  
}
