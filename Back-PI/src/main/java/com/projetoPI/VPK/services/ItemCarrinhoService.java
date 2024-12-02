package com.projetoPI.VPK.services;


import com.projetoPI.VPK.model.ItemCarrinho;
import com.projetoPI.VPK.repository.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    public ItemCarrinho salvar(ItemCarrinho itemCarrinho) {
        return itemCarrinhoRepository.save(itemCarrinho);
    }

    public ItemCarrinho findById(Long id) {
        return itemCarrinhoRepository.findById(id).orElse(null);
    }
    public List<ItemCarrinho> findByIdCarrinho(Long id){
        return itemCarrinhoRepository.findItemCarrinhoByCarrinhoId(id);
    }
}
