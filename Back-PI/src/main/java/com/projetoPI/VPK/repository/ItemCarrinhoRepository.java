package com.projetoPI.VPK.repository;

import com.projetoPI.VPK.model.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {

    public List<ItemCarrinho> findItemCarrinhoByCarrinhoId(Long carrinhoId);
}
