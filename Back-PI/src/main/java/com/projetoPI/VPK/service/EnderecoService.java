package com.projetoPI.VPK.service;

import com.projetoPI.VPK.exception.custom.NotFoundException;
import com.projetoPI.VPK.model.Endereco;
import com.projetoPI.VPK.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private IEnderecoRepository repository;

    @Autowired
    public EnderecoService(IEnderecoRepository repository) {
        this.repository = repository;
    }

    public Endereco findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<Endereco> findAll() {return this.repository.findAll();}

    public Endereco save(Endereco endereco) {return this.repository.save(endereco);}

    public Endereco update(Endereco endereco) {return this.repository.save(endereco);}

    public void delete(Long id) {this.repository.deleteById(id);}
}
