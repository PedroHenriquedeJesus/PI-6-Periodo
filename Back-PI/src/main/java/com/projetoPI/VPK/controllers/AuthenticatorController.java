package com.projetoPI.VPK.controllers;


import com.projetoPI.VPK.Security.TokenService;
import com.projetoPI.VPK.model.User;
import com.projetoPI.VPK.model.dto.AuthenticatorDTO;
import com.projetoPI.VPK.model.dto.RegisterDTO;
import com.projetoPI.VPK.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticatorController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody @Valid AuthenticatorDTO dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);


        User user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(user);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", user); // Adiciona o objeto User diretamente

        return ResponseEntity.ok(response);
    }

    @PostMapping ("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO dto ){
        if(this.repository.findByEmail(dto.email()) != null)return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());

        User newUser = new User(dto.email(),encryptedPassword,dto.role(),dto.telefone(),dto.CPF(), dto.nome());
        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
