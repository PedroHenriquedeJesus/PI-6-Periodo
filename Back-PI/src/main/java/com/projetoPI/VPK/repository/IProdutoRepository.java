package com.projetoPI.VPK.repository;

import com.projetoPI.VPK.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long> {
}
