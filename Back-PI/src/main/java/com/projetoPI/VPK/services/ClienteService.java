package com.projetoPI.VPK.services;
import com.projetoPI.VPK.model.*;
import com.projetoPI.VPK.model.dto.ClienteDTO;
import com.projetoPI.VPK.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        return new ClienteDTO(cliente);
    }

    public Cliente findCompletUserById(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }



    public List<ClienteDTO> findAll() {
        List<Cliente> result = clienteRepository.findAll();
        return result.stream().map(x -> new ClienteDTO(x)).toList();
    }
}
