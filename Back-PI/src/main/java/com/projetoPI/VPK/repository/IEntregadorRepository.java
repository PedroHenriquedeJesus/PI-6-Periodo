package com.projetoPI.VPK.repository;

import com.projetoPI.VPK.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntregadorRepository extends JpaRepository<Entregador, Long> {
}
