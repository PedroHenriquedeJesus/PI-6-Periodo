package com.projetoPI.VPK.service;

import com.projetoPI.VPK.exception.custom.NotFoundException;
import com.projetoPI.VPK.model.Produto;
import com.projetoPI.VPK.repository.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private IProdutoRepository repository;

    public Produto findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<Produto> findAll() {return this.repository.findAll();}

    public Produto save(Produto produto) {return this.repository.save(produto);}

    public Produto update(Produto produto) {return this.repository.save(produto);}

    public void delete(Long id) {this.repository.deleteById(id);}
}
