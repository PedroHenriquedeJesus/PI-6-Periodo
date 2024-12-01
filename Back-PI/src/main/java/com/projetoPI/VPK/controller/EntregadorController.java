package com.projetoPI.VPK.controller;

import com.projetoPI.VPK.model.Entregador;
import com.projetoPI.VPK.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/entregador")
public class EntregadorController {
    @Autowired
    private EntregadorService entregadorService;

    @GetMapping(value = "/{id}")
    public Entregador findById(@PathVariable Long id) {return entregadorService.findById(id);}

    @GetMapping
    public List<Entregador> findAll() {return entregadorService.findAll();}

    @PostMapping
    public Entregador save(@RequestBody Entregador entregador) {return entregadorService.save(entregador);}

    @PutMapping
    public Entregador update(@RequestBody Entregador entregador) {return entregadorService.update(entregador);}

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {entregadorService.delete(id);}
}
