package com.projetoPI.VPK.repository;

import com.projetoPI.VPK.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
