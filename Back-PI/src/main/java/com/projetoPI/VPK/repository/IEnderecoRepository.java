package com.projetoPI.VPK.repository;

import com.projetoPI.VPK.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {
}
