package com.project.joga10.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
         httpSecurity
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(HttpMethod.POST, "/login").permitAll()
        .requestMatchers(HttpMethod.PUT, "/atualizaUsuario").permitAll()
         .requestMatchers(HttpMethod.POST, "/cadastraCartao").permitAll()
         .requestMatchers(HttpMethod.POST, "/cadastroEstabelecimento").permitAll()
         .requestMatchers(HttpMethod.POST, "/cadastroUsuario").permitAll()
          .requestMatchers(HttpMethod.GET, "/consultaUsuario").permitAll()
           .requestMatchers(HttpMethod.POST, "/criarPartidas").permitAll()
            .requestMatchers(HttpMethod.GET, "/lista-usuarios").permitAll()
             .requestMatchers(HttpMethod.GET, "/listaPartidas").permitAll()
              .requestMatchers(HttpMethod.POST, "/partidaPorId").permitAll()
              
                .anyRequest().authenticated()
          
               
                
        ); //.authenticationProvider(authenticationProvider);
               // .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);       
        return httpSecurity.build();
    }
  
  
}
