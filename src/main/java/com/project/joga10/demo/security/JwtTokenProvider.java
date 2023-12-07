package com.project.joga10.demo.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.project.joga10.demo.entity.User;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class JwtTokenProvider {

   @Autowired
    private UserDetailsService userDetailsService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpirationInMs;

    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        // Certifique-se de que userDetails seja uma instância de User
        if (userDetails instanceof User) {
            User user = (User) userDetails;

            return Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .claim("nome", user.getPrimeiroNome())          // Adicione o nome ao token
                    .claim("sobrenome", user.getSegundoNome())
                    .claim("id_user", user.getId()) 
                    .claim("bairro", user.getBairro())
                    .claim("cidade", user.getCidade())
                    .claim("complemento", user.getComplemento())
                    .claim("rua", user.getRua())
                      .claim("contato", user.getContato())
                   
                    .setIssuedAt(new Date())
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
        }

        return null; // Lide com outros tipos de UserDetails, se necessário
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch 
        ( MalformedJwtException | ExpiredJwtException | 
        UnsupportedJwtException | IllegalArgumentException ex) {
            
            return false;
        }
    }
     public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromToken(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
}
