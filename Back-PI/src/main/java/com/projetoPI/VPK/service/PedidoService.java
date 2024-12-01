package com.projetoPI.VPK.service;

import com.projetoPI.VPK.exception.custom.NotFoundException;
import com.projetoPI.VPK.model.Pedido;
import com.projetoPI.VPK.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private IPedidoRepository repository;

    @Autowired
    public PedidoService(IPedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<Pedido> findAll() {return this.repository.findAll();}

    public Pedido save(Pedido pedido) {return this.repository.save(pedido);}

    public Pedido update(Pedido pedido) {return this.repository.save(pedido);}

    public void delete(Long id) {this.repository.deleteById(id);}
}
