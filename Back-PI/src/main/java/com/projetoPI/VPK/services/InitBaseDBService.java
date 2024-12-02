
package com.projetoPI.VPK.services;


import com.projetoPI.VPK.model.*;
import com.projetoPI.VPK.model.enums.*;
import com.projetoPI.VPK.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InitBaseDBService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void InstanciaDB() {
        //Entregadores
        Entregador entregador1 = new Entregador(null, "Kayky", "CBA-013", Disponibilidade.DISPONIVEL, 14);
        Entregador entregador2 = new Entregador(null, "Pedro", "TSF-736", Disponibilidade.EM_ROTA, 12);
        Entregador entregador3 = new Entregador(null, "Vinicius", "OFI-138", Disponibilidade.INDISPONIVEL, 20);
        entregadorRepository.saveAll(Arrays.asList(entregador1, entregador2, entregador3));

        //Usuários
        Cliente cliente1 = new Cliente(null, "User", "123.456.789-11", "user@email.com", "(64) 11111111", "12345678", RoleUsers.user);
        Cliente cliente2 = new Cliente(null, "Lucas", "941.123.753-06", "lucas@email.com", "(62) 99639534", "abc123", RoleUsers.admin);
        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

        // Produtos
        Produto produto1 = new Produto(null, "Marmita Tradicional", "Arroz, feijão, bife e salada", "https://example.com/marmitaBasica.jpg", 15.50, 4, null);
        Produto produto2 = new Produto(null, "Marmita Premium", "Bisteca, arroz carreteiro e feijãoTropeito", "https://example.com/marmitaPremiun.jpg", 23.00, 5, null);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2));

        // Endereços
        Endereco endereco1 = new Endereco(null, "Rua A", "Próximo ao colegio X", "12345-678", "Apto 203", 10, null, cliente1);
        Endereco endereco2 = new Endereco(null, "Rua B", "Perto da praça A", "23456-789", "rua D", 5, null, cliente2);
        Endereco endereco3 = new Endereco(null, "Rua C", "Em frente ao antigo orfanato", "34567-890", "Casa 101 lt00", 11, null, cliente1);

        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));
    }
}
