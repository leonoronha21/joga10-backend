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
        .requestMatchers(HttpMethod.PUT, "/atualiza-Usuario").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/cadastr-Cartao").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/cadastroEstabelecimento").permitAll()
         .requestMatchers(HttpMethod.POST, "/cadastroUsuario").permitAll()
         .requestMatchers(HttpMethod.GET, "/consulta-Usuario").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/criar-Partidas").hasRole("user"))
         .requestMatchers(HttpMethod.GET, "/lista-usuarios").hasRole("user")
         .requestMatchers(HttpMethod.GET, "/lista-partidas").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/partida-PorId").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/partidas-PorUsuario").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/partidas-Ativas").hasRole("user")
         .requestMatchers(HttpMethod.GET, "/estabelecimentos").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/cartao-UserId").hasRole("user")
         .requestMatchers(HttpMethod.GET, "/lista-CartoesUser").hasRole("user")
         .requestMatchers(HttpMethod.GET, "/quadra").hasRole("user")
         .requestMatchers(HttpMethod.PUT, "/finaliza-Partida").hasRole("user")
         .requestMatchers(HttpMethod.POST, "/adicionaMembros").hasRole("user")
                .anyRequest().authenticated()
          
               
                
        ) //.authenticationProvider(authenticationProvider);
               .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);       
        return httpSecurity.build();
    }
  
  
}
