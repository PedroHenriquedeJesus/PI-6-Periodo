package com.projetoPI.VPK.repository;

import com.projetoPI.VPK.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    UserDetails findByEmail(String email);
}
