package com.projetoPI.VPK.controllers;


import com.projetoPI.VPK.model.dto.ClienteDTO;
import com.projetoPI.VPK.repository.ClienteRepository;
import com.projetoPI.VPK.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService service;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
        ClienteDTO usuario = service.findById(id);
        return  ResponseEntity.ok(usuario);
    }


    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){

        List<ClienteDTO> dto =service.findAll();
        return ResponseEntity.ok(dto);
    }
}
