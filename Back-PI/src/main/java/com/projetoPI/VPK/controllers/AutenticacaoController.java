package com.projetoPI.VPK.controllers;


import com.projetoPI.VPK.Security.TokenService;
import com.projetoPI.VPK.model.Cliente;
import com.projetoPI.VPK.model.dto.AutenticacaoDTO;
import com.projetoPI.VPK.model.dto.RegistrarDTO;
import com.projetoPI.VPK.repository.ClienteRepository;
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
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody @Valid AutenticacaoDTO dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);


        Cliente cliente = (Cliente) authentication.getPrincipal();
        String token = tokenService.generateToken(cliente);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", cliente); // Adiciona o objeto User diretamente

        return ResponseEntity.ok(response);
    }

    @PostMapping ("/register")
    public ResponseEntity register(@RequestBody @Valid RegistrarDTO dto ){
        if(this.repository.findByEmail(dto.email()) != null)return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());

        Cliente newCliente = new Cliente(dto.email(),encryptedPassword,dto.role(),dto.telefone(),dto.CPF(), dto.nome());
        this.repository.save(newCliente);

        return ResponseEntity.ok().build();
    }

}
