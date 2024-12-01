package com.projetoPI.VPK.service;

import com.projetoPI.VPK.exception.custom.NotFoundException;
import com.projetoPI.VPK.model.Endereco;
import com.projetoPI.VPK.model.Entregador;
import com.projetoPI.VPK.repository.IEntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {

    private IEntregadorRepository repository;

    @Autowired
    public EntregadorService(IEntregadorRepository repository) {
        this.repository = repository;
    }

    public Entregador findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<Entregador> findAll() {return this.repository.findAll();}

    public Entregador save(Entregador entregador) {return this.repository.save(entregador);}

    public Entregador update(Entregador entregador) {return this.repository.save(entregador);}

    public void delete(Long id) {this.repository.deleteById(id);}
}
