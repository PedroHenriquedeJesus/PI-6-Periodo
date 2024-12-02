package com.projetoPI.VPK.services;


import com.projetoPI.VPK.model.Produto;
import com.projetoPI.VPK.model.dto.ProdutoDTO;
import com.projetoPI.VPK.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public ProdutoDTO findById(Long id) {
        Produto prod = repository.findById(id).get();
        return new ProdutoDTO(prod);

    }
    public Produto findCompleteProductFromId(Long id) {
        return repository.findById(id).get();
    }
    public ProdutoDTO Insert(ProdutoDTO dto) {
        Produto prod = new Produto();
        copyDtoToEntity(dto,prod);
        prod = repository.save(prod);
        return new ProdutoDTO(prod);
    }





    private void copyDtoToEntity(ProdutoDTO dto, Produto entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImage(dto.getImage());
    }

    public ProdutoDTO Update(Long id, ProdutoDTO dto) {
            Produto entity = repository.getReferenceById(id);
             copyDtoToEntity(dto,entity);
             entity = repository.save(entity);
             return new ProdutoDTO(entity);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ProdutoDTO> findAll() {
        List<Produto> result = repository.findAll();
        return result.stream().map(x -> new ProdutoDTO(x)).toList();
    }
}
