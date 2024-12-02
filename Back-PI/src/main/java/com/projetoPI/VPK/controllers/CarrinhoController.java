package com.projetoPI.VPK.controllers;


import com.projetoPI.VPK.model.Carrinho;
import com.projetoPI.VPK.model.dto.SalvarCarrinhoDto;
import com.projetoPI.VPK.services.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {


    @Autowired
    private CarrinhoService carrinhoService;
    @PostMapping("/")
    public Carrinho salvar(@RequestBody SalvarCarrinhoDto carrinho) {
        return carrinhoService.salvar(carrinho);
    }
}
