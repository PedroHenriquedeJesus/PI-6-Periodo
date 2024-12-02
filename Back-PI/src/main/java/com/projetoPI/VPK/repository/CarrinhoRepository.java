package com.projetoPI.VPK.repository;

import com.projetoPI.VPK.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    public Carrinho findCarrinhoByUsuarioId(Long id);
}
