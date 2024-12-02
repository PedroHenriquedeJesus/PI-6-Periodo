package com.projetoPI.VPK.services;

import com.projetoPI.VPK.model.*;
import com.projetoPI.VPK.model.enums.*;
import com.projetoPI.VPK.model.dto.*;
import com.projetoPI.VPK.repository.EnderecoRepository;
import com.projetoPI.VPK.repository.PedidoRepository;
import com.projetoPI.VPK.repository.ProdutoRepository;
import com.projetoPI.VPK.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;


    public PedidoDTO findById(Long id) {

        Pedido pedido = pedidoRepository.findById(id).get();
        return new PedidoDTO(pedido);

    }


    public @Valid PedidoDTO insert(@Valid PedidoDTO dto) {
        // Cria uma nova entidade Pedido
        Pedido pedido = new Pedido();
        pedido.setData(Instant.now());
        pedido.setStatus(StatusDoPedido.PREPARANDO);

        // Associa o usuário ao pedido
        Cliente cliente = clienteRepository.findById(dto.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        pedido.setUser(cliente);

        // Associa o endereço ao pedido
        if (dto.getEndereco() != null && dto.getEndereco().getId() != null) {
            Endereco endereco = enderecoRepository.findById(dto.getEndereco().getId())
                    .orElseThrow(() -> new RuntimeException("Endereco not found"));
            pedido.setEndereco(endereco);
        }

        // Adiciona os itens do pedido
        for (ItemPedidoDTO itemDto : dto.getItensPedido()) {
            ItemPedido itemPedido = new ItemPedido();

            // Carrega o Produto usando o ID e associa ao item do pedido
            Produto produto = produtoRepository.findById(itemDto.getProdutoid())
                    .orElseThrow(() -> new RuntimeException("Produto not found"));

            itemPedido.setProduto(produto);
            itemPedido.setPreco(produto.getPrice()); // Usa o preço do produto diretamente
            itemPedido.setQuantidade(itemDto.getQuantidade());

            // Associa o item ao pedido
            itemPedido.setPedido(pedido);
            pedido.getItens().add(itemPedido);
        }

        // Salva o pedido no banco de dados
        pedido = pedidoRepository.save(pedido);

        // Retorna o DTO do pedido sem referenciar os itens ou outros dados desnecessários
        return new PedidoDTO(pedido);
    }



    public @Valid PedidoDTO update(Long id, @Valid PedidoDTO dto) {
        // Busca o pedido existente pelo ID
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido not found"));

        // Atualiza os campos do pedido com os dados do DTO
        pedido.setData(dto.getData());
        pedido.setStatus(dto.getStatus());

        // Atualiza o usuário, se o ID for fornecido
        if (dto.getUser() != null && dto.getUser().getId() != null) {
            Cliente cliente = clienteRepository.findById(dto.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            pedido.setUser(cliente);
        }

        // Atualiza o endereço
        if (dto.getEndereco() != null && dto.getEndereco().getId() != null) {
            Endereco endereco = enderecoRepository.findById(dto.getEndereco().getId())
                    .orElseThrow(() -> new RuntimeException("Endereco not found"));
            pedido.setEndereco(endereco);
        }

        // Atualiza os itens do pedido
        // Remove os itens antigos (garante que não haja duplicações)
        pedido.getItens().clear();

        // Adiciona os novos itens
        for (ItemPedidoDTO itemDto : dto.getItensPedido()) {
            ItemPedido itemPedido = new ItemPedido();

            // Carregar o Produto completo usando o ID
            Produto produto = produtoRepository.findById(itemDto.getProdutoid())
                    .orElseThrow(() -> new RuntimeException("Produto not found"));

            // Não permite que o preço venha do DTO, pega diretamente do Produto
            itemPedido.setProduto(produto);
            itemPedido.setPreco(produto.getPrice());  // Preço do produto carregado do banco

            itemPedido.setQuantidade(itemDto.getQuantidade());

            // Associa o item ao pedido
            itemPedido.setPedido(pedido);
            pedido.getItens().add(itemPedido);
        }

        // Salva as atualizações no banco de dados
        pedido = pedidoRepository.save(pedido);

        // Retorna o DTO atualizado
        return new PedidoDTO(pedido);
    }







    public List<PedidoDTO> findAll() {
        List<Pedido> result = pedidoRepository.findAll();
        return result.stream().map(x -> new PedidoDTO(x)).toList();
    }

    public void delete(Long id) {
    pedidoRepository.deleteById(id);

    }
}
